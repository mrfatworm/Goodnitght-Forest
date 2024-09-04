/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mrfatworm.goodnightforest.ui.theme.AppTheme
import com.mrfatworm.goodnightforest.ui.theme.white300
import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.ic_google
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun LoginIconButton(iconRes: DrawableResource = Res.drawable.ic_google, onClick: () -> Unit = {}) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState()

    Surface(
        modifier = Modifier.clickable(interactionSource = interactionSource,
            indication = ripple(radius = 16.dp),
            onClick = { onClick() }),
        shape = RoundedCornerShape(16.dp),
        color = if (isPressed.value) white300 else Color(0x1AFFFFFF),
        border = if (isPressed.value) BorderStroke(
            width = 2.5.dp, color = AppTheme.colors.primaryDefault
        ) else BorderStroke(width = 1.dp, color = AppTheme.colors.text3)
    ) {
        Icon(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 18.dp)
                .size(20.dp),
            imageVector = vectorResource(iconRes),
            contentDescription = null,
            tint = AppTheme.colors.text1
        )
    }
}