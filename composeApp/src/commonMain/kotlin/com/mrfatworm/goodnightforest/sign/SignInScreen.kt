/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.sign

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mrfatworm.goodnightforest.ui.component.GnfTextFiled
import com.mrfatworm.goodnightforest.ui.component.LoginIconButton
import com.mrfatworm.goodnightforest.ui.component.PrimaryButton
import com.mrfatworm.goodnightforest.ui.theme.AppTheme
import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.account
import goodnitght_forest.composeapp.generated.resources.bg_1
import goodnitght_forest.composeapp.generated.resources.ic_apple
import goodnitght_forest.composeapp.generated.resources.ic_facebook
import goodnitght_forest.composeapp.generated.resources.ic_google
import goodnitght_forest.composeapp.generated.resources.invalid_email
import goodnitght_forest.composeapp.generated.resources.no_account
import goodnitght_forest.composeapp.generated.resources.password
import goodnitght_forest.composeapp.generated.resources.sign_in
import goodnitght_forest.composeapp.generated.resources.sign_in_by_another_way
import goodnitght_forest.composeapp.generated.resources.sign_in_later
import goodnitght_forest.composeapp.generated.resources.sign_up
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

const val emailPattern = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
        "\\@" +
        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
        "(" +
        "\\." +
        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
        ")+"
val emailRegex = emailPattern.toRegex()

@Composable
fun SignInScreen(onSignInClick: () -> Unit = {}) {
    val emailText = remember { mutableStateOf("") }
    val passwordText = remember { mutableStateOf("") }
    val emailError = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .drawWithCache {
                    onDrawWithContent {
                        drawContent()
                        drawRect(
                            brush = Brush.verticalGradient(
                                colors = listOf(Color(0xC41D1A3E), Color(0x001D1A3E)),
                                startY = 0f,
                                endY = size.height / 2
                            )
                        )
                        drawRect(
                            brush = Brush.verticalGradient(
                                colors = listOf(Color(0xE81D1A3E), Color(0x001D1A3E)),
                                startY = size.height,
                                endY = size.height / 3
                            )
                        )
                    }
                },
            painter = painterResource(Res.drawable.bg_1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.15f,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = AppTheme.dimens.s24),
            verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.s24)
        ) {
            Spacer(modifier = Modifier.size(96.dp))
            Text(
                text = stringResource(Res.string.sign_in),
                style = AppTheme.typography.h4,
                color = AppTheme.colors.text1
            )
            Column(verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.s16)) {
                GnfTextFiled(
                    modifier = Modifier.fillMaxWidth(),
                    text = emailText.value,
                    title = stringResource(Res.string.account),
                    onTextChange = {
                        emailText.value = it
                        emailError.value =
                            !emailText.value.matches(emailRegex)
                    },
                    placeholder = stringResource(
                        Res.string.account
                    ),
                    error = emailError.value,
                    startHint = if (emailError.value) stringResource(Res.string.invalid_email) else null,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
                    )
                )

                GnfTextFiled(
                    modifier = Modifier.fillMaxWidth(),
                    text = passwordText.value,
                    title = stringResource(Res.string.password),
                    onTextChange = {
                        passwordText.value = it
                    },
                    placeholder = stringResource(
                        Res.string.password
                    ),
                    isPassword = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password, imeAction = ImeAction.Done
                    )
                )

                PrimaryButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .imePadding()
                        .padding(top = 68.dp),
                    text = stringResource(Res.string.sign_in),
                    enabled = emailText.value.matches(emailRegex) && (passwordText.value.isNotBlank()),
                    onClick = onSignInClick
                )

                Text(modifier = Modifier
                    .clickable { onSignInClick() }
                    .fillMaxWidth(),
                    text = stringResource(Res.string.sign_in_later),
                    textAlign = TextAlign.Center,
                    color = AppTheme.colors.text2,
                    style = AppTheme.typography.s5)

                Row(
                    modifier = Modifier.padding(top = 48.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HorizontalDivider(modifier = Modifier.weight(1f), color = AppTheme.colors.text3)
                    Text(
                        modifier = Modifier.padding(horizontal = AppTheme.dimens.s16),
                        text = stringResource(Res.string.sign_in_by_another_way),
                        color = AppTheme.colors.text3,
                        style = AppTheme.typography.s6
                    )
                    HorizontalDivider(modifier = Modifier.weight(1f), color = AppTheme.colors.text3)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = AppTheme.dimens.s16),
                    horizontalArrangement = Arrangement.spacedBy(
                        AppTheme.dimens.s12, Alignment.CenterHorizontally
                    )
                ) {
                    LoginIconButton(Res.drawable.ic_facebook)
                    LoginIconButton(Res.drawable.ic_google)
                    LoginIconButton(Res.drawable.ic_apple)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp),
                    horizontalArrangement = Arrangement.spacedBy(
                        AppTheme.dimens.s4, Alignment.CenterHorizontally
                    )
                ) {
                    Text(
                        stringResource(Res.string.no_account),
                        color = AppTheme.colors.text3,
                        style = AppTheme.typography.s6
                    )
                    Text(
                        stringResource(Res.string.sign_up),
                        color = AppTheme.colors.text1,
                        style = AppTheme.typography.s6
                    )
                }
            }
        }
    }
}