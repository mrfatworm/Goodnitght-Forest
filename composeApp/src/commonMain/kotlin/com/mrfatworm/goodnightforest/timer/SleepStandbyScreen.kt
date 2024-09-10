/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.timer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.mrfatworm.goodnightforest.ui.component.LessonPagerItem
import com.mrfatworm.goodnightforest.ui.component.PrimaryButton
import com.mrfatworm.goodnightforest.ui.component.SecondaryButton
import com.mrfatworm.goodnightforest.ui.component.data.sampleLessonPager
import com.mrfatworm.goodnightforest.ui.theme.AppTheme
import com.mrfatworm.goodnightforest.ui.theme.ColorScheme
import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.alarm_not_set
import goodnitght_forest.composeapp.generated.resources.bg_5
import goodnitght_forest.composeapp.generated.resources.ic_alarm
import goodnitght_forest.composeapp.generated.resources.long_click_to_finish_record
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class, ExperimentalComposeUiApi::class)
@Composable
fun SleepStandbyScreen(onBackClick: () -> Unit = {}) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize().align(Alignment.TopCenter).drawWithCache {
                    onDrawWithContent {
                        drawContent()
                        drawRect(
                            brush = Brush.verticalGradient(
                                listOf(ColorScheme().bg1, ColorScheme().bg1.copy(alpha = 0.16f)),
                                startY = size.height,
                                endY = size.height / 3
                            )
                        )
                    }
                },
            painter = painterResource(Res.drawable.bg_5),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.2f,
        )
        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val now = Clock.System.now()
            val localTime = now.toLocalDateTime(TimeZone.currentSystemDefault())
            val localTimeFormated = localTime.format(LocalDateTime.Format {
                hour()
                chars(":")
                minute()
            })
            Text(
                modifier = Modifier.padding(top = 120.dp),
                text = localTimeFormated,
                color = AppTheme.colors.text1,
                style = AppTheme.typography.h1
            )
            SecondaryButton(
                modifier = Modifier.padding(top = 20.dp),
                text = stringResource(Res.string.alarm_not_set),
                hasIcon = true,
                iconRes = Res.drawable.ic_alarm
            )

            val pagerState = rememberPagerState(pageCount = { 5 })
            val coroutineScope = rememberCoroutineScope()

            Spacer(modifier = Modifier.size(72.dp))
            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(
                    horizontal = 100.dp
                ),
                pageSpacing = 0.dp,
            ) { page ->
                LessonPagerItem(Modifier.size(200.dp).graphicsLayer {
                        // Calculate the absolute offset for the current page from the
                        // scroll position. We use the absolute value which allows us to mirror
                        // any effects for both directions
                        val pageOffset =
                            ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue
                        // We animate the alpha, between 75% and 100%
                        lerp(
                            start = 0.75f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                    },
                    sampleLessonPager.lessonPagers[page],
                    isForeground = pagerState.currentPage == page,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page)
                        }
                    })
            }

            Spacer(modifier = Modifier.size(120.dp))
            val interactionSource = remember { MutableInteractionSource() }
            val isPressed = interactionSource.collectIsPressedAsState()
            var countdown by remember { mutableIntStateOf(4) }

            LaunchedEffect(isPressed.value) {
                if (isPressed.value) {
                    countdown = 3 // 倒數開始從 3
                    for (i in 3 downTo 1) {
                        countdown = i
                        delay(1000) // 每秒倒數
                    }
                    onBackClick()
                } else {
                    countdown = 4 // 停止長按時重置倒數
                }
            }

            PrimaryButton(
                Modifier.width(160.dp),
                text = if (countdown > 3) stringResource(Res.string.long_click_to_finish_record)
                else countdown.toString(),
                interactionSource = interactionSource
            )
        }
    }
}