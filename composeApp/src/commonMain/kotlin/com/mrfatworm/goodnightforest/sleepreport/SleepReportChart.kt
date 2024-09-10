/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.sleepreport

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mrfatworm.goodnightforest.sleepreport.data.SleepHistogramState
import com.mrfatworm.goodnightforest.ui.theme.AppTheme
import com.mrfatworm.goodnightforest.ui.theme.white50
import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.awake
import goodnitght_forest.composeapp.generated.resources.deep_sleep
import goodnitght_forest.composeapp.generated.resources.light_sleep
import goodnitght_forest.composeapp.generated.resources.rem
import goodnitght_forest.composeapp.generated.resources.time_template_minute
import goodnitght_forest.composeapp.generated.resources.time_template_time_slots_hour
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun SleepReportChart(
    modifier: Modifier = Modifier, sleepHistograms: List<SleepHistogramState>
) {
    Column(
        modifier.fillMaxWidth().height(IntrinsicSize.Min)
            .background(white50, RoundedCornerShape(16.dp)).padding(12.dp).padding(top = 52.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(Modifier.weight(1f), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Column(
                Modifier.fillMaxHeight().padding(bottom = 24.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                for (min in 40 downTo 10 step 10) {
                    Text(
                        text = stringResource(Res.string.time_template_minute, min),
                        color = AppTheme.colors.text2,
                        style = AppTheme.typography.t5
                    )
                }
            }
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(Modifier.weight(1f).height(200.dp), verticalAlignment = Alignment.Bottom) {
                    sleepHistograms.forEach { sleepHistogram ->
                        Histogram(Modifier.weight(1f), sleepHistogram)

                    }
                }
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    val startHour = sleepHistograms.first().hours
                    val endMinute = sleepHistograms.last().minutes
                    val endHour =
                        if (endMinute > 0) sleepHistograms.last().hours + 1 else sleepHistograms.last().hours
                    for (hour in startHour..endHour step (2)) {
                        Text(
                            text = stringResource(
                                Res.string.time_template_time_slots_hour, "上午", hour
                            ), color = AppTheme.colors.text2, style = AppTheme.typography.t5
                        )
                    }
                }
            }
        }

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            SleepQualityIndicator(Res.string.awake, AppTheme.colors.primaryLight)
            SleepQualityIndicator(Res.string.light_sleep, AppTheme.colors.primaryDefault)
            SleepQualityIndicator(Res.string.deep_sleep, AppTheme.colors.primaryDark)
            SleepQualityIndicator(Res.string.rem, AppTheme.colors.secondaryDefault)
        }
    }
}

@Composable
private fun Histogram(modifier: Modifier, sleepHistogram: SleepHistogramState) {
    Spacer(
        modifier = modifier.height((200 * sleepHistogram.sleepTime).dp).background(
            sleepHistogram.sleepQuality.color, RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp)
        )
    )
}

@Composable
fun SleepQualityIndicator(textRes: StringResource, color: Color) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier.size(8.dp).background(color, CircleShape)
        )
        Text(
            text = stringResource(textRes),
            color = AppTheme.colors.text2,
            style = AppTheme.typography.s8
        )
    }
}