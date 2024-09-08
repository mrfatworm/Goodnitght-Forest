/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mrfatworm.goodnightforest.ui.navigaiton.BottomScreens
import com.mrfatworm.goodnightforest.ui.navigaiton.GnfNavActions
import com.mrfatworm.goodnightforest.ui.theme.AppTheme
import com.mrfatworm.goodnightforest.ui.theme.ColorScheme
import com.mrfatworm.goodnightforest.ui.theme.blue300
import com.mrfatworm.goodnightforest.ui.theme.blue700
import com.mrfatworm.goodnightforest.ui.theme.white200
import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.home
import goodnitght_forest.composeapp.generated.resources.ic_home
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun GnfBottomNavigation(
    modifier: Modifier = Modifier, selectedDestination: String, navActions: GnfNavActions?
) {
    Row(
        modifier = modifier.fillMaxWidth().padding(
                start = 16.dp, end = 16.dp, bottom = 24.dp
            ).background(color = AppTheme.colors.bg2, shape = CircleShape).offset(y = (-16).dp)
            .padding(horizontal = 48.dp), verticalAlignment = Alignment.Bottom
    ) {
        BottomScreens.forEach { screen ->
            val selected = selectedDestination == screen.route
            NavItem(modifier = Modifier.weight(1f),
                selected = selected,
                iconDefaultRes = screen.iconDefaultRes ?: Res.drawable.ic_home,
                iconSelectedRes = screen.iconSelectedRes ?: Res.drawable.ic_home,
                textRes = screen.textRes ?: Res.string.home,
                onClick = {
                    if (!selected) {
                        navActions?.navigationToTopAndSave(screen)
                    }
                })
        }
    }
}

@Composable
fun NavItem(
    modifier: Modifier = Modifier,
    iconDefaultRes: DrawableResource,
    iconSelectedRes: DrawableResource,
    textRes: StringResource,
    selected: Boolean = false,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.clickable(
            interactionSource = remember { MutableInteractionSource() }, indication = ripple()
        ) { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(if (selected) 4.dp else 6.dp)
    ) {
        if (selected) {
            Icon(modifier = Modifier.drawWithContent {
                    drawCircle(color = ColorScheme().bg1, radius = size.minDimension / 2.2f)
                    drawCircle(
                        brush = Brush.radialGradient(
                            listOf(
                                Color(0x80FFFFFF), Color(0x00FFFFFF)
                            )
                        )
                    )
                    drawContent()
                }.padding(8.dp).background(
                    Brush.verticalGradient(listOf(blue300, blue700)), shape = CircleShape
                ).border(1.dp, white200, CircleShape).padding(10.dp),
                imageVector = vectorResource(iconSelectedRes),
                contentDescription = stringResource(textRes),
                tint = Color.Unspecified)


        } else {
            Icon(
                imageVector = vectorResource(iconDefaultRes),
                contentDescription = stringResource(textRes),
                tint = Color.Unspecified
            )
        }
        Text(
            text = stringResource(textRes),
            style = AppTheme.typography.t5,
            color = if (selected) AppTheme.colors.text1 else AppTheme.colors.secondaryLight.copy(
                alpha = 0.5f
            )
        )

    }
}