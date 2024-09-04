/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */
package com.mrfatworm.goodnightforest.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mrfatworm.goodnightforest.ui.theme.AppTheme
import com.mrfatworm.goodnightforest.ui.utils.innerShadow
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource


val shadowWhite = Color.White.copy(0.8f)
val bubbleBackground = Brush.horizontalGradient(listOf(Color(0x00FFFFFF), Color(0xCC344577)))

@Composable
fun BubbleButton(
    modifier: Modifier = Modifier, textRes: StringResource, iconRes: DrawableResource, onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(modifier = modifier
        .clickable(
            interactionSource = interactionSource, indication = ripple(radius = 64.dp)
        ) { onClick() }
        // Draw the background.
        .background(bubbleBackground, CircleShape, alpha = 0.7f)
        // Glare effect
        .innerShadow(
            shape = CircleShape, color = shadowWhite, offsetY = 0.dp, offsetX = 0.dp, blur = 15.dp
        )
        .padding(vertical = AppTheme.dimens.s12, horizontal = AppTheme.dimens.s24),
        horizontalArrangement = Arrangement.spacedBy(AppTheme.dimens.s4),
        verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = vectorResource(iconRes),
            contentDescription = stringResource(textRes),
            tint = AppTheme.colors.icon1
        )
        Text(
            text = stringResource(textRes),
            color = AppTheme.colors.buttonText,
            style = AppTheme.typography.h6
        )
    }
}

@Composable
fun BubbleIconButton(textRes: StringResource, iconRes: DrawableResource, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState()
    Column(
        modifier = Modifier.clickable(
            interactionSource = interactionSource, indication = null
        ) { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.s8)
    ) {
        Icon(
            modifier = Modifier
                .background(bubbleBackground, CircleShape, alpha = 0.7f)
                .innerShadow(
                    shape = CircleShape,
                    color = shadowWhite,
                    offsetY = 0.dp,
                    offsetX = 0.dp,
                    blur = 15.dp
                )
                .padding(10.dp),
            imageVector = vectorResource(iconRes),
            contentDescription = stringResource(textRes),
            tint = if (isPressed.value) AppTheme.colors.icon1.copy(alpha = 0.4f) else AppTheme.colors.icon1
        )
        Text(
            text = stringResource(textRes),
            color = if (isPressed.value) AppTheme.colors.text2.copy(alpha = 0.4f) else AppTheme.colors.text2,
            style = AppTheme.typography.s7
        )
    }
}

@Composable
fun BubbleBox(modifier: Modifier = Modifier, radius: Dp = AppTheme.radius.r48) {
    Spacer(
        modifier = modifier
            .background(bubbleBackground, RoundedCornerShape(radius), alpha = 0.7f)
            // Glare effect
            .innerShadow(
                shape = RoundedCornerShape(radius),
                color = shadowWhite,
                offsetY = 0.dp,
                offsetX = 0.dp,
                blur = 15.dp,
            )
    )
}