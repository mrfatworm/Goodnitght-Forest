/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mrfatworm.goodnightforest.ui.theme.AppTheme
import com.mrfatworm.goodnightforest.ui.theme.white300
import com.mrfatworm.goodnightforest.ui.theme.white50
import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.ic_close
import goodnitght_forest.composeapp.generated.resources.ic_invisible
import goodnitght_forest.composeapp.generated.resources.ic_visible
import org.jetbrains.compose.resources.vectorResource

@Composable
fun GnfTextFiled(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    title: String? = null,
    startHint: String? = null,
    endHint: String? = null,
    placeholder: String,
    error: Boolean = false,
    enabled: Boolean = true,
    isPassword: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    val passwordInvisible = remember { mutableStateOf(true) }
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        if (title != null) {
            Text(text = title, style = AppTheme.typography.s6, color = AppTheme.colors.text1)
        }
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = onTextChange,
            placeholder = {
                Text(
                    text = placeholder,
                    color = AppTheme.colors.text2,
                    style = AppTheme.typography.t2
                )
            },
            textStyle = AppTheme.typography.t2,
            enabled = enabled,
            isError = error,
            shape = RoundedCornerShape(AppTheme.radius.textFiled),
            colors = textFiledColors(),
            keyboardOptions = keyboardOptions,
            visualTransformation = if (isPassword && passwordInvisible.value) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                if (isPassword) {
                    IconButton(modifier = Modifier.padding(end = 8.dp), onClick = {
                        passwordInvisible.value = !passwordInvisible.value
                    }) {
                        Icon(
                            vectorResource(if (passwordInvisible.value) Res.drawable.ic_invisible else Res.drawable.ic_visible),
                            contentDescription = null,
                            tint = AppTheme.colors.icon1
                        )
                    }
                } else if (text.isNotBlank()) {
                    IconButton(
                        modifier = Modifier.padding(end = 8.dp),
                        onClick = { onTextChange("") }) {
                        Icon(
                            vectorResource(Res.drawable.ic_close),
                            contentDescription = "close",
                            tint = AppTheme.colors.icon1
                        )
                    }
                }
            })
        Row(modifier.padding(horizontal = 16.dp)) {
            if (startHint != null) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = startHint,
                    color = if (error) AppTheme.colors.danger else AppTheme.colors.text2,
                    style = AppTheme.typography.t4
                )
            }
            if (endHint != null) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = endHint,
                    textAlign = TextAlign.End,
                    color = if (error) AppTheme.colors.danger else AppTheme.colors.text2,
                    style = AppTheme.typography.t4
                )
            }
        }
    }
}

@Composable
fun textFiledColors() = OutlinedTextFieldDefaults.colors(
    focusedTextColor = AppTheme.colors.text1,
    focusedContainerColor = white300,
    focusedBorderColor = AppTheme.colors.primaryDefault,
    unfocusedTextColor = AppTheme.colors.text1,
    unfocusedContainerColor = Color(0x1AFFFFFF),
    unfocusedBorderColor = AppTheme.colors.text2,
    errorTextColor = AppTheme.colors.text1,
    errorContainerColor = Color(0x1AFFFFFF),
    errorCursorColor = AppTheme.colors.text1,
    cursorColor = AppTheme.colors.text1,
    disabledTextColor = AppTheme.colors.text4,
    disabledContainerColor = white50,
    disabledBorderColor = AppTheme.colors.text3
)