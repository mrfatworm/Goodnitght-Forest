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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mrfatworm.goodnightforest.sleepreport.data.SleepQualityState
import com.mrfatworm.goodnightforest.sleepreport.data.SleepReportState
import com.mrfatworm.goodnightforest.sleepreport.data.sampleSleepReportState
import com.mrfatworm.goodnightforest.ui.component.GnfTopBar
import com.mrfatworm.goodnightforest.ui.theme.AppTheme
import com.mrfatworm.goodnightforest.ui.theme.white300
import com.mrfatworm.goodnightforest.ui.theme.white50
import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.average
import goodnitght_forest.composeapp.generated.resources.decibel
import goodnitght_forest.composeapp.generated.resources.ic_big_bed
import goodnitght_forest.composeapp.generated.resources.ic_sleep_moon
import goodnitght_forest.composeapp.generated.resources.on_bed_time
import goodnitght_forest.composeapp.generated.resources.per_hour
import goodnitght_forest.composeapp.generated.resources.sleep_report
import goodnitght_forest.composeapp.generated.resources.sleep_report_last_night
import goodnitght_forest.composeapp.generated.resources.sleep_time
import goodnitght_forest.composeapp.generated.resources.time_template_hour_min
import goodnitght_forest.composeapp.generated.resources.times
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun SleepReportScreen(uiState: SleepReportState = sampleSleepReportState) {
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GnfTopBar(title = stringResource(Res.string.sleep_report), hasBack = false)
        SleepDashBoard(Modifier.padding(top = 32.dp), 214.dp, percentage = uiState.sleepQuality)
        Row(
            modifier = Modifier.fillMaxWidth().padding(24.dp)
                .background(white50, RoundedCornerShape(16.dp))
                .padding(horizontal = 32.dp, vertical = 12.dp).height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            SleepInfoItem(
                Res.drawable.ic_big_bed, Res.string.on_bed_time, stringResource(
                    Res.string.time_template_hour_min,
                    uiState.onBedTime.hours,
                    uiState.onBedTime.minutes
                )
            )
            VerticalDivider(modifier = Modifier.fillMaxHeight(), color = white300)
            SleepInfoItem(
                Res.drawable.ic_sleep_moon, Res.string.sleep_time, stringResource(
                    Res.string.time_template_hour_min,
                    uiState.sleepTime.hours,
                    uiState.sleepTime.minutes
                )
            )
        }

        Text(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
            text = stringResource(Res.string.sleep_report_last_night),
            color = AppTheme.colors.text1,
            style = AppTheme.typography.h6
        )
        SleepReportChart(
            modifier = Modifier.padding(24.dp), sleepHistograms = uiState.sleepHistogramStateList
        )

        Column(
            Modifier.fillMaxWidth().padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            uiState.sleepAnalysisStateList.forEach { sleepAnalysisState ->
                SleepAnalysisItem(
                    Modifier.fillMaxWidth(),
                    textRes = sleepAnalysisState.titleRes,
                    times = sleepAnalysisState.times,
                    sleepQualityState = sleepAnalysisState.sleepQualityState
                )
            }
        }
        Spacer(modifier = Modifier.height(AppTheme.dimens.bottomNavigationSpace))

    }
}

@Composable
private fun SleepInfoItem(
    iconRes: DrawableResource = Res.drawable.ic_big_bed,
    textRes: StringResource = Res.string.sleep_time,
    time: String
) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Icon(
            modifier = Modifier.size(40.dp),
            imageVector = vectorResource(iconRes),
            contentDescription = null,
            tint = AppTheme.colors.icon1
        )
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text = time, color = AppTheme.colors.text1, style = AppTheme.typography.s6
            )
            Text(
                text = stringResource(textRes),
                color = AppTheme.colors.text2,
                style = AppTheme.typography.t4
            )
        }
    }
}


@Composable
private fun SleepAnalysisItem(
    modifier: Modifier,
    textRes: StringResource = Res.string.sleep_time,
    times: String,
    sleepQualityState: SleepQualityState?,
    isDecibel: Boolean = false
) {
    Row(
        modifier = modifier.background(white50, RoundedCornerShape(16.dp)).padding(16.dp)
            .height(IntrinsicSize.Min), horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Column {
            Text(
                text = stringResource(textRes),
                color = AppTheme.colors.text1,
                style = AppTheme.typography.h7
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = stringResource(Res.string.average),
                    color = AppTheme.colors.text2,
                    style = AppTheme.typography.t5
                )
                Text(
                    text = times, color = AppTheme.colors.text1, style = AppTheme.typography.t1
                )
                Text(
                    text = stringResource(if (isDecibel) Res.string.decibel else Res.string.times),
                    color = AppTheme.colors.text2,
                    style = AppTheme.typography.t5
                )
            }
            Text(
                text = stringResource(Res.string.per_hour),
                color = AppTheme.colors.text2,
                style = AppTheme.typography.t4
            )
        }
        if (sleepQualityState != null) {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = vectorResource(sleepQualityState.iconRes),
                    contentDescription = stringResource(sleepQualityState.textRes),
                    tint = sleepQualityState.color
                )
                Column(
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = stringResource(sleepQualityState.textRes),
                        color = sleepQualityState.color,
                        style = AppTheme.typography.t5
                    )
                    Spacer(
                        modifier = Modifier.fillMaxWidth(0.5f).height(4.dp)
                            .background(sleepQualityState.color, RoundedCornerShape(4.dp))
                    )
                }
            }
        }
    }
}