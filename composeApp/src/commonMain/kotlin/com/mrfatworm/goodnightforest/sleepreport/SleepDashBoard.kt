/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.sleepreport

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mrfatworm.goodnightforest.sleepreport.data.sleepQualityBad
import com.mrfatworm.goodnightforest.sleepreport.data.sleepQualityExcellent
import com.mrfatworm.goodnightforest.sleepreport.data.sleepQualityGood
import com.mrfatworm.goodnightforest.sleepreport.data.sleepQualityWorst
import com.mrfatworm.goodnightforest.ui.theme.AppTheme
import com.mrfatworm.goodnightforest.ui.theme.white700
import com.mrfatworm.goodnightforest.ui.utils.drawDashBoardLines
import com.mrfatworm.goodnightforest.ui.utils.drawDashBoardProgress
import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.ic_info
import goodnitght_forest.composeapp.generated.resources.sleep_quality
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun SleepDashBoard(modifier: Modifier = Modifier, size: Dp, percentage: Float) {
    Box(modifier = modifier) {
        val strokeWidth = 17.dp
        val angleSize = 310f
        val inPreviewMode = LocalInspectionMode.current
        val startAnimation = remember { mutableStateOf(false) }
        val dashBoardAnimation = animateFloatAsState(
            targetValue = if (startAnimation.value || inPreviewMode) percentage else 0f,
            animationSpec = keyframes {
                durationMillis = 2500
                0.0f at 0 using FastOutLinearInEasing // for 0-1000 ms
                percentage - 0.05f at 1000 using LinearOutSlowInEasing // Slowdown in 1000-2500 ms
            },
            label = "keyframe"
        )

        LaunchedEffect("startAnimation") {
            startAnimation.value = true
        }
        val sleepQualityState by remember {
            mutableStateOf(
                when (percentage) {
                    in 0f..0.29f -> {
                        sleepQualityWorst
                    }

                    in 0.30f..0.59f -> {
                        sleepQualityBad
                    }

                    in 0.60f..0.79f -> {
                        sleepQualityGood
                    }

                    else -> {
                        sleepQualityExcellent
                    }
                }
            )
        }

        val baseColors = Brush.verticalGradient(listOf(white700, white700))
        val progressColors = sleepQualityState.brush

        Canvas(
            Modifier.size(size).padding(strokeWidth / 2)
        ) {
            drawDashBoardProgress(angleSize, baseColors, 1f, strokeWidth)
            drawDashBoardProgress(angleSize, progressColors, dashBoardAnimation.value, strokeWidth)
            drawDashBoardLines(angleSize, 35)
        }

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${(dashBoardAnimation.value * 100).toInt()}%",
                color = sleepQualityState.color,
                style = AppTheme.typography.h2
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(Res.string.sleep_quality),
                    color = AppTheme.colors.text1,
                    style = AppTheme.typography.s6
                )
                Icon(
                    modifier = Modifier.padding(4.dp),
                    imageVector = vectorResource(Res.drawable.ic_info),
                    contentDescription = null,
                    tint = AppTheme.colors.icon1
                )
            }
        }
        Icon(
            modifier = Modifier.align(Alignment.BottomCenter).size(40.dp),
            imageVector = vectorResource(sleepQualityState.iconRes),
            contentDescription = null,
            tint = sleepQualityState.color
        )
    }
}