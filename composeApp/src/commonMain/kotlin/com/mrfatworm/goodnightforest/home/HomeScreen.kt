/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.home

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mrfatworm.goodnightforest.ui.component.BubbleBox
import com.mrfatworm.goodnightforest.ui.component.BubbleButton
import com.mrfatworm.goodnightforest.ui.component.BubbleIconButton
import com.mrfatworm.goodnightforest.ui.theme.AppTheme
import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.bg_2
import goodnitght_forest.composeapp.generated.resources.explore_your_sleep_companion
import goodnitght_forest.composeapp.generated.resources.goodnight
import goodnitght_forest.composeapp.generated.resources.ic_alert
import goodnitght_forest.composeapp.generated.resources.ic_bed
import goodnitght_forest.composeapp.generated.resources.ic_sleep_moon
import goodnitght_forest.composeapp.generated.resources.ic_tool
import goodnitght_forest.composeapp.generated.resources.my_companion
import goodnitght_forest.composeapp.generated.resources.set_alarm
import goodnitght_forest.composeapp.generated.resources.sleep_now
import goodnitght_forest.composeapp.generated.resources.sleep_tool
import goodnitght_forest.composeapp.generated.resources.who_will_you_meet_tonight
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomeScreen(onExploreCompanionClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        HomeBackgroundImage()
        HomeContent(onExploreCompanionClick)
    }
}

@Composable
private fun HomeBackgroundImage() {
    Image(
        modifier = Modifier.fillMaxSize().drawWithCache {
            onDrawWithContent {
                drawContent()
                drawRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xE81D1A3E), Color(0x001D1A3E)),
                        startY = size.height,
                        endY = size.height / 3
                    )
                )
            }
        },
        painter = painterResource(Res.drawable.bg_2),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        alpha = 0.5f,
    )
}

@Composable
private fun HomeContent(onExploreCompanionClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(start = 24.dp, end = 24.dp, top = 110.dp)
        ) {
            Text(
                text = stringResource(Res.string.goodnight),
                color = AppTheme.colors.text1,
                style = AppTheme.typography.h4
            )
            Text(
                text = stringResource(Res.string.who_will_you_meet_tonight),
                color = AppTheme.colors.text1,
                style = AppTheme.typography.t3
            )
        }

        val interactionSource = remember { MutableInteractionSource() }
        Box(
            modifier = Modifier.clickable(interactionSource = interactionSource,
                indication = null,
                onClick = { onExploreCompanionClick() }).padding(top = 32.dp).padding(16.dp)
                .padding(8.dp), contentAlignment = Alignment.Center
        ) {
            AnimateBox()
            BubbleBox(
                modifier = Modifier.size(128.dp).rotate(15f)
            )
            Text(
                text = stringResource(Res.string.explore_your_sleep_companion),
                textAlign = TextAlign.Center,
                color = AppTheme.colors.text1,
                style = AppTheme.typography.h6
            )
        }
        BubbleButton(modifier = Modifier.padding(top = 96.dp),
            Res.string.sleep_now,
            Res.drawable.ic_sleep_moon,
            onClick = {})

        Row(
            modifier = Modifier.padding(top = 56.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                48.dp, Alignment.CenterHorizontally
            )
        ) {
            BubbleIconButton(Res.string.set_alarm, Res.drawable.ic_alert, onClick = {})
            BubbleIconButton(Res.string.my_companion, Res.drawable.ic_tool, onClick = {})
            BubbleIconButton(Res.string.sleep_tool, Res.drawable.ic_bed, onClick = {})
        }
    }
}


@Composable
private fun AnimateBox() {
    var currentRotation1 by remember { mutableFloatStateOf(0f) }
    var currentRotation2 by remember { mutableFloatStateOf(135f) }
    val animateRotation1 = remember { Animatable(currentRotation1) }
    val animateRotation2 = remember { Animatable(currentRotation2) }

    LaunchedEffect(true) {
        animateRotation1.animateTo(
            targetValue = currentRotation1 - 360f, animationSpec = infiniteRepeatable(
                animation = tween(6400, easing = LinearEasing)
            )
        ) {
            currentRotation1 = value
        }
    }
    LaunchedEffect(true) {
        animateRotation2.animateTo(
            targetValue = currentRotation2 + 360f, animationSpec = infiniteRepeatable(
                animation = tween(7200, easing = LinearEasing)
            )
        ) {
            currentRotation2 = value
        }
    }
    Spacer(
        modifier = Modifier.size(148.dp).rotate(currentRotation1).background(
            Brush.horizontalGradient(listOf(Color(0x33FFFFFF), Color(0x80FFFFFF))),
            RoundedCornerShape(AppTheme.radius.bubble)
        )
    )
    Spacer(
        modifier = Modifier.size(154.dp).rotate(currentRotation2).background(
            Brush.horizontalGradient(listOf(Color(0x33FFFFFF), Color(0x80FFFFFF))),
            RoundedCornerShape(AppTheme.radius.bubble)
        )
    )
}