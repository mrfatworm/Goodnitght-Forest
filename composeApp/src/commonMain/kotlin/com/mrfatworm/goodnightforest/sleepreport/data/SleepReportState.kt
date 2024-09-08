/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.sleepreport.data

data class SleepReportState(
    val sleepQuality: Float,
    val onBedTime: TimeState,
    val sleepTime: TimeState,
    val sleepHistogramStateList: List<SleepHistogramState>,
    val sleepAnalysisStateList: List<SleepAnalysisState>
)

data class TimeState(val hours: Int, val minutes: Int)

private val onBedTime = TimeState(8, 10)
private val sleepTime = TimeState(7, 10)

val sampleSleepReportState = SleepReportState(
    0.75f, onBedTime, sleepTime,sampleSleepHistogramList, sampleSleepAnalysisStateList
)

