/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.ui.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.mrfatworm.goodnightforest.ui.theme.AppTheme
import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.ic_left
import org.jetbrains.compose.resources.vectorResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GnfTopBar(
    title: String? = null,
    hasBack: Boolean = true,
    onBackClick: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {}
) {
    CenterAlignedTopAppBar(title = {
        title?.let {
            Text(
                text = title, style = AppTheme.typography.h6, color = AppTheme.colors.text1
            )
        }
    }, navigationIcon = {
        if (hasBack) {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    vectorResource(Res.drawable.ic_left), contentDescription = "Back"
                )
            }
        }
    }, actions = {
        actions()
    }, colors = TopAppBarColors(
        containerColor = Color.Transparent,
        scrolledContainerColor = Color.Transparent,
        navigationIconContentColor = AppTheme.colors.icon1,
        titleContentColor = AppTheme.colors.text1,
        actionIconContentColor = AppTheme.colors.icon1,
    )
    )
}