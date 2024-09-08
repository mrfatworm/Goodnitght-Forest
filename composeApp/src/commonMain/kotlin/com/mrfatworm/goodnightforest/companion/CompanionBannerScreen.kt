/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.companion

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.mrfatworm.goodnightforest.companion.data.CompanionCard
import com.mrfatworm.goodnightforest.companion.data.companionLumina
import com.mrfatworm.goodnightforest.ui.component.GnfTopBar
import com.mrfatworm.goodnightforest.ui.component.LessonListItem
import com.mrfatworm.goodnightforest.ui.component.PrimaryButton
import com.mrfatworm.goodnightforest.ui.component.data.lessonList
import com.mrfatworm.goodnightforest.ui.theme.AppTheme
import com.mrfatworm.goodnightforest.ui.theme.ColorScheme
import com.mrfatworm.goodnightforest.ui.theme.white300
import com.mrfatworm.goodnightforest.ui.theme.white400
import com.mrfatworm.goodnightforest.ui.theme.white900
import com.mrfatworm.goodnightforest.ui.utils.dropShadow
import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.banner_cover
import goodnitght_forest.composeapp.generated.resources.bg_4
import goodnitght_forest.composeapp.generated.resources.click_to_pull
import goodnitght_forest.composeapp.generated.resources.ic_tool
import goodnitght_forest.composeapp.generated.resources.sleep_companion
import goodnitght_forest.composeapp.generated.resources.start
import goodnitght_forest.composeapp.generated.resources.try_another_way_to_help_sleep
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@Composable
fun CompanionBannerScreen(
    companionCard: CompanionCard = companionLumina, onBackClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.align(Alignment.TopCenter).fillMaxWidth().fillMaxHeight(0.7f)
                .drawWithCache {
                    onDrawWithContent {
                        drawContent()
                        drawRect(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    ColorScheme().bg1, ColorScheme().bg1.copy(alpha = 0f)
                                ), startY = size.height, endY = size.height / 2
                            )
                        )
                    }
                },
            painter = painterResource(Res.drawable.bg_4),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.2f,
        )
        Column(
            modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState())
        ) {
            GnfTopBar(title = stringResource(Res.string.sleep_companion),
                onBackClick = { onBackClick() },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_tool),
                            contentDescription = null
                        )
                    }
                })

            var filped by remember { mutableStateOf(false) }
            val rotation by animateFloatAsState(
                targetValue = if (filped) 180f else 0f, animationSpec = tween(500), label = ""
            )
            Box(modifier = Modifier.padding(24.dp).clickable { filped = !filped }.graphicsLayer {
                    rotationY = rotation
                    cameraDistance = 8 * density
                }, contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    modifier = Modifier.fillMaxWidth().dropShadow(
                            shape = RoundedCornerShape(AppTheme.radius.cardLarge),
                            color = Color(0x99D6D0F5),
                            blur = if (filped) 0.dp else 16.dp
                        ).aspectRatio(0.72f).clip(RoundedCornerShape(AppTheme.radius.cardLarge))
                        .border(1.dp, white300, RoundedCornerShape(AppTheme.radius.cardLarge)),
                    painter = painterResource(if (rotation > 90) companionCard.imageRes else Res.drawable.banner_cover),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                if (rotation > 90) {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)
                            .graphicsLayer { rotationY = 180f },
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Text(
                                text = companionCard.name,
                                color = AppTheme.colors.text1,
                                style = AppTheme.typography.h4
                            )
                            Text(
                                modifier = Modifier.background(
                                        white400, RoundedCornerShape(24.dp)
                                    ).padding(
                                        horizontal = 12.dp, vertical = 4.dp
                                    ),
                                text = companionCard.tag,
                                color = white900,
                                style = AppTheme.typography.s7
                            )
                            Text(
                                text = companionCard.time.toString() + "分鐘",
                                color = AppTheme.colors.text1,
                                style = AppTheme.typography.t4
                            )
                        }
                        Text(
                            text = companionCard.desc,
                            color = AppTheme.colors.text1,
                            style = AppTheme.typography.t4
                        )
                        PrimaryButton(
                            modifier = Modifier.padding(
                                    top = 8.dp, bottom = 24.dp
                                ).fillMaxWidth(), text = stringResource(Res.string.start)
                        )
                    }

                } else {
                    Text(
                        modifier = Modifier.padding(bottom = 40.dp),
                        text = stringResource(Res.string.click_to_pull),
                        color = AppTheme.colors.text1,
                        style = AppTheme.typography.s6
                    )
                }
            }

            Text(
                modifier = Modifier.padding(top = 20.dp).padding(horizontal = 24.dp),
                text = stringResource(Res.string.try_another_way_to_help_sleep),
                style = AppTheme.typography.h6,
                color = AppTheme.colors.text1
            )

            Row(
                modifier = Modifier.padding(top = 16.dp).horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Spacer(modifier = Modifier.size(12.dp))
                lessonList.forEach { lesson ->
                    LessonListItem(uiState = lesson)
                }
            }
        }
    }

}