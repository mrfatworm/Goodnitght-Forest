/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mrfatworm.goodnightforest.ui.theme.AppTheme
import com.mrfatworm.goodnightforest.ui.theme.white250
import com.mrfatworm.goodnightforest.ui.theme.white900
import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.ic_home
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String = "Button",
    hasIcon: Boolean = false,
    iconRes: DrawableResource = Res.drawable.ic_home,
    enabled: Boolean = true,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    onClick: () -> Unit = {}
) {
    GnfButton(
        modifier = modifier.height(46.dp),
        containerColor = AppTheme.colors.primaryDefault,
        contentColor = AppTheme.colors.bg1,
        disabledContainerColor = white900,
        disabledContentColor = AppTheme.colors.text2,
        text = text,
        hasIcon = hasIcon,
        iconRes = iconRes,
        enabled = enabled,
        elevation = elevation,
        onClick = onClick,
    )
}

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    text: String = "Button",
    hasIcon: Boolean = false,
    iconRes: DrawableResource = Res.drawable.ic_home,
    enabled: Boolean = true,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    onClick: () -> Unit = {}
) {
    GnfButton(
        modifier = modifier.height(46.dp),
        containerColor = white250,
        contentColor = AppTheme.colors.buttonText,
        disabledContainerColor = white900,
        disabledContentColor = AppTheme.colors.text2,
        text = text,
        hasIcon = hasIcon,
        iconRes = iconRes,
        enabled = enabled,
        elevation = elevation,
        onClick = onClick
    )
}

@Composable
fun GnfButton(
    modifier: Modifier = Modifier,
    containerColor: Color,
    contentColor: Color,
    disabledContainerColor: Color,
    disabledContentColor: Color,
    text: String = "Button",
    hasIcon: Boolean = false,
    iconRes: DrawableResource = Res.drawable.ic_home,
    enabled: Boolean = true,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    onClick: () -> Unit = {},
) {
    Button(
        modifier = modifier.height(50.dp), shape = RoundedCornerShape(64.dp), colors = ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor
        ), enabled = enabled, elevation = elevation, onClick = onClick
    ) {
        if (hasIcon) {
            Icon(
                modifier = Modifier.padding(end = 4.dp).size(20.dp),
                imageVector = vectorResource(iconRes),
                contentDescription = ""
            )
        }
        Text(
            text = text, style = AppTheme.typography.h6
        )
    }
}