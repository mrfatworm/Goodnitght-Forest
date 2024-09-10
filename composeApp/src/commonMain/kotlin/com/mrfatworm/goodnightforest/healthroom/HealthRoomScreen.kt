/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.healthroom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.mrfatworm.goodnightforest.ui.component.ArticleItem
import com.mrfatworm.goodnightforest.ui.component.ArticleLargeItem
import com.mrfatworm.goodnightforest.ui.component.GnfTopBar
import com.mrfatworm.goodnightforest.ui.component.data.sampleBookedArticleList
import com.mrfatworm.goodnightforest.ui.component.data.samplePopularArticleList
import com.mrfatworm.goodnightforest.ui.component.data.sampleSuggestArticleList
import com.mrfatworm.goodnightforest.ui.theme.AppTheme
import com.mrfatworm.goodnightforest.ui.utils.TrapezoidCanvas
import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.bg_3
import goodnitght_forest.composeapp.generated.resources.booked_article
import goodnitght_forest.composeapp.generated.resources.ic_arrow_right
import goodnitght_forest.composeapp.generated.resources.ic_calendar
import goodnitght_forest.composeapp.generated.resources.online_doctor
import goodnitght_forest.composeapp.generated.resources.popular_article
import goodnitght_forest.composeapp.generated.resources.recommend_article
import goodnitght_forest.composeapp.generated.resources.see_more
import goodnitght_forest.composeapp.generated.resources.sleep_health_room
import goodnitght_forest.composeapp.generated.resources.suggest_article
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun HealthRoomScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxWidth().size(300.dp).align(Alignment.TopCenter),
            painter = painterResource(Res.drawable.bg_3),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.7f,
        )
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
        ) {
            GnfTopBar(
                title = stringResource(Res.string.sleep_health_room),
                hasBack = false,
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_calendar),
                            contentDescription = null
                        )
                    }
                })
            TabRow()
            Column(
                modifier = Modifier.fillMaxWidth().background(AppTheme.colors.bg1)
            ) {
                Spacer(modifier = Modifier.size(12.dp))
                ImagesListTitle(Res.string.suggest_article)
                LazyRow(contentPadding = PaddingValues(horizontal = 24.dp)) {
                    items(sampleSuggestArticleList) { article ->
                        ArticleLargeItem(modifier = Modifier.size(192.dp), uiState = article)
                        Spacer(modifier = Modifier.size(16.dp))
                    }
                }
                Spacer(modifier = Modifier.size(16.dp))
                ImagesListTitle(Res.string.booked_article)
                LazyRow(contentPadding = PaddingValues(horizontal = 24.dp)) {
                    items(sampleBookedArticleList) { article ->
                        ArticleItem(modifier = Modifier.width(144.dp), uiState = article)
                        Spacer(modifier = Modifier.size(16.dp))
                    }
                }
                Spacer(modifier = Modifier.size(16.dp))
                ImagesListTitle(Res.string.popular_article)
                LazyRow(contentPadding = PaddingValues(horizontal = 24.dp)) {
                    items(samplePopularArticleList) { article ->
                        ArticleItem(modifier = Modifier.width(144.dp), uiState = article)
                        Spacer(modifier = Modifier.size(16.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.size(AppTheme.dimens.bottomNavigationSpace))
        }
    }
}

@Composable
private fun ImagesListTitle(textRes: StringResource) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(start = 24.dp, end = 8.dp, top = 12.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(textRes),
            color = AppTheme.colors.text1,
            style = AppTheme.typography.h6
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(Res.string.see_more),
                color = AppTheme.colors.text1,
                style = AppTheme.typography.s7
            )
            Icon(
                painter = painterResource(Res.drawable.ic_arrow_right),
                contentDescription = null,
                tint = AppTheme.colors.icon1
            )
        }
    }
}

@Composable
private fun TabItem(modifier: Modifier, textRes: StringResource, isSelected: Boolean) {
    Box(modifier = modifier) {
        if (isSelected) {
            TrapezoidCanvas(Modifier.matchParentSize(), AppTheme.colors.bg1)
        }
        Text(
            modifier = Modifier.align(Alignment.BottomCenter).padding(top = 12.dp, bottom = 4.dp)
                .padding(end = 16.dp),
            text = stringResource(textRes),
            color = if (isSelected) AppTheme.colors.text2 else AppTheme.colors.text1,
            style = AppTheme.typography.h6
        )
    }
}

@Composable
private fun TabRow() {
    Row(modifier = Modifier.fillMaxWidth()) {
        TabItem(
            Modifier.weight(1f), textRes = Res.string.recommend_article, isSelected = true
        )
        TabItem(Modifier.weight(1f), textRes = Res.string.online_doctor, isSelected = false)
    }
}