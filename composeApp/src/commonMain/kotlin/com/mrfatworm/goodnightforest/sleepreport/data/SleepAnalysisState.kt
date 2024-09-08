/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.sleepreport.data

import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.breath_break
import goodnitght_forest.composeapp.generated.resources.breath_frequency
import goodnitght_forest.composeapp.generated.resources.cough_status
import goodnitght_forest.composeapp.generated.resources.decibel
import goodnitght_forest.composeapp.generated.resources.environment_noise
import goodnitght_forest.composeapp.generated.resources.heart_rate
import goodnitght_forest.composeapp.generated.resources.snore_status
import goodnitght_forest.composeapp.generated.resources.times
import org.jetbrains.compose.resources.StringResource


data class SleepAnalysisState(
    val titleRes: StringResource,
    val times: String,
    val unitRes: StringResource,
    val sleepQualityState: SleepQualityState?
)

val sampleSleepAnalysisStateList = listOf(
    SleepAnalysisState(
        Res.string.breath_break, "26.2", Res.string.times, sleepQualityWorst,
    ), SleepAnalysisState(
        Res.string.snore_status, "4", Res.string.times, sleepQualityGood,
    ), SleepAnalysisState(
        Res.string.cough_status, "0.2", Res.string.times, sleepQualityExcellent,
    ), SleepAnalysisState(
        Res.string.environment_noise, "10", Res.string.decibel, sleepQualityExcellent,
    ), SleepAnalysisState(
        Res.string.breath_frequency, "19", Res.string.times, sleepQualityGood,
    ), SleepAnalysisState(
        Res.string.heart_rate, "40", Res.string.times, null
    )
)
