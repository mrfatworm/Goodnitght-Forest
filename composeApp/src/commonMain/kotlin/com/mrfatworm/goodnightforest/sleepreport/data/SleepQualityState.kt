/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.sleepreport.data

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.mrfatworm.goodnightforest.ui.theme.ColorScheme
import com.mrfatworm.goodnightforest.ui.theme.green900
import com.mrfatworm.goodnightforest.ui.theme.red900
import com.mrfatworm.goodnightforest.ui.theme.white900
import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.high
import goodnitght_forest.composeapp.generated.resources.ic_face_bad
import goodnitght_forest.composeapp.generated.resources.ic_face_excellent
import goodnitght_forest.composeapp.generated.resources.ic_face_good
import goodnitght_forest.composeapp.generated.resources.ic_face_worst
import goodnitght_forest.composeapp.generated.resources.low
import goodnitght_forest.composeapp.generated.resources.medium
import goodnitght_forest.composeapp.generated.resources.very_high
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

data class SleepQualityState(
    val iconRes: DrawableResource, val textRes: StringResource, val color: Color, val brush: Brush
)

val sleepQualityExcellent = SleepQualityState(
    Res.drawable.ic_face_excellent,
    Res.string.low,
    color = ColorScheme().success,
    Brush.linearGradient(
        listOf(green900, ColorScheme().successLight)
    )
)

val sleepQualityGood = SleepQualityState(
    Res.drawable.ic_face_good,
    Res.string.medium,
    color = ColorScheme().warning,
    Brush.verticalGradient(
        listOf(ColorScheme().warningLight, ColorScheme().warning)
    )
)

val sleepQualityBad = SleepQualityState(
    Res.drawable.ic_face_bad,
    Res.string.high,
    color = ColorScheme().dangerLight,
    Brush.verticalGradient(
        listOf(white900, ColorScheme().dangerLight)
    )
)

val sleepQualityWorst = SleepQualityState(
    Res.drawable.ic_face_worst,
    Res.string.very_high,
    color = ColorScheme().danger,
    Brush.verticalGradient(
        listOf(ColorScheme().dangerLight, red900)
    )
)