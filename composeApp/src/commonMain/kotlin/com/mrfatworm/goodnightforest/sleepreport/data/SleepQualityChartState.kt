/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.sleepreport.data

import androidx.annotation.FloatRange
import androidx.compose.ui.graphics.Color
import com.mrfatworm.goodnightforest.ui.theme.ColorScheme
import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.awake
import goodnitght_forest.composeapp.generated.resources.deep_sleep
import goodnitght_forest.composeapp.generated.resources.light_sleep
import goodnitght_forest.composeapp.generated.resources.rem
import org.jetbrains.compose.resources.StringResource

data class SleepHistogramState(
    val sleepQuality: SleepStatus,
    @FloatRange(from = 0.0, to = 1.0) val sleepTime: Float,
    val hours: Int,
    val minutes: Int
)

sealed class SleepStatus(val textRes: StringResource, val color: Color) {
    data object Awake : SleepStatus(Res.string.awake, ColorScheme().primaryLight)
    data object LightSleep : SleepStatus(Res.string.light_sleep, ColorScheme().primaryDefault)
    data object DeepSleep : SleepStatus(Res.string.deep_sleep, ColorScheme().primaryDark)
    data object REM : SleepStatus(Res.string.rem, ColorScheme().secondaryDefault)

}

val sampleSleepHistogramList = listOf(
    SleepHistogramState(
        SleepStatus.Awake, 0.97f, 1, 5
    ),
    SleepHistogramState(
        SleepStatus.Awake, 0.97f, 1, 10
    ),
    SleepHistogramState(
        SleepStatus.Awake, 0.92f, 1, 15
    ),
    SleepHistogramState(
        SleepStatus.Awake, 0.92f, 1, 20
    ),
    SleepHistogramState(
        SleepStatus.Awake, 0.89f, 1, 25
    ),
    SleepHistogramState(
        SleepStatus.Awake, 0.86f, 1, 30
    ),
    SleepHistogramState(
        SleepStatus.Awake, 0.82f, 1, 35
    ),
    SleepHistogramState(
        SleepStatus.Awake, 0.82f, 1, 40
    ),
    SleepHistogramState(
        SleepStatus.Awake, 0.82f, 1, 45
    ),
    SleepHistogramState(
        SleepStatus.Awake, 0.82f, 1, 50
    ),
    SleepHistogramState(
        SleepStatus.Awake, 0.79f, 1, 55
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.78f, 2, 0
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.78f, 2, 5
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.76f, 2, 10
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.76f, 2, 15
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.77f, 2, 20
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.77f, 2, 25
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.74f, 2, 30
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.74f, 2, 35
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.74f, 2, 40
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.72f, 2, 45
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.72f, 2, 50
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.68f, 2, 55
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.68f, 3, 0
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.69f, 3, 5
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.69f, 3, 10
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.69f, 3, 15
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.66f, 3, 20
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.68f, 3, 25
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.68f, 3, 30
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.71f, 3, 35
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.71f, 3, 40
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.69f, 3, 45
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.68f, 3, 50
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.69f, 3, 55
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.65f, 4, 0
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.68f, 4, 5
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.68f, 4, 10
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.66f, 4, 15
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.62f, 4, 20
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.62f, 4, 25
    ),
    SleepHistogramState(
        SleepStatus.DeepSleep, 0.60f, 4, 30
    ),
    SleepHistogramState(
        SleepStatus.DeepSleep, 0.62f, 4, 35
    ),
    SleepHistogramState(
        SleepStatus.DeepSleep, 0.62f, 4, 40
    ),
    SleepHistogramState(
        SleepStatus.DeepSleep, 0.61f, 4, 45
    ),
    SleepHistogramState(
        SleepStatus.DeepSleep, 0.61f, 4, 50
    ),
    SleepHistogramState(
        SleepStatus.DeepSleep, 0.62f, 4, 55
    ),
    SleepHistogramState(
        SleepStatus.DeepSleep, 0.59f, 5, 0
    ),
    SleepHistogramState(
        SleepStatus.DeepSleep, 0.55f, 5, 5
    ),
    SleepHistogramState(
        SleepStatus.DeepSleep, 0.58f, 5, 10
    ),
    SleepHistogramState(
        SleepStatus.DeepSleep, 0.58f, 5, 15
    ),
    SleepHistogramState(
        SleepStatus.DeepSleep, 0.63f, 5, 20
    ),
    SleepHistogramState(
        SleepStatus.DeepSleep, 0.63f, 5, 25
    ),
    SleepHistogramState(
        SleepStatus.REM, 0.60f, 5, 30
    ),
    SleepHistogramState(
        SleepStatus.REM, 0.60f, 5, 35
    ),
    SleepHistogramState(
        SleepStatus.REM, 0.56f, 5, 40
    ),
    SleepHistogramState(
        SleepStatus.REM, 0.56f, 5, 45
    ),
    SleepHistogramState(
        SleepStatus.REM, 0.60f, 5, 50
    ),
    SleepHistogramState(
        SleepStatus.REM, 0.62f, 5, 55
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.63f, 6, 0
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.65f, 6, 5
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.61f, 6, 10
    ),
    SleepHistogramState(
        SleepStatus.LightSleep, 0.63f, 6, 15
    ),
    SleepHistogramState(
        SleepStatus.Awake, 0.68f, 6, 20
    ),
    SleepHistogramState(
        SleepStatus.Awake, 0.71f, 6, 25
    ),
)
