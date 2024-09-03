/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier


/**
 * Ref:
 * [Building an Efficient UI Design System with Jetpack Compose and Compose Multiplatform](https://medium.com/@ahmednasser_12958/building-an-efficient-ui-design-system-0a049b6ee3f7)
 */
private val localDimens = staticCompositionLocalOf { Dimens() }
private val localColorScheme = staticCompositionLocalOf { ColorScheme() }
private val localRadius = staticCompositionLocalOf { Radius() }
private val localTypography = staticCompositionLocalOf { Typography() }

object AppTheme {
    val colors: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = localColorScheme.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = localTypography.current

    val radius: Radius
        @Composable
        @ReadOnlyComposable
        get() = localRadius.current

    val dimens: Dimens
        @Composable
        @ReadOnlyComposable
        get() = localDimens.current
}


@Composable
fun AppTheme(content: @Composable () -> Unit) {

    val colorScheme = ColorScheme()

    val typography = Typography(
        h0 = provideTypography().h0,
        h1 = provideTypography().h1,
        h2 = provideTypography().h2,
        h3 = provideTypography().h3,
        h4 = provideTypography().h4,
        h5 = provideTypography().h5,
        h6 = provideTypography().h6,
        h7 = provideTypography().h7,
        s1 = provideTypography().s1,
        s2 = provideTypography().s2,
        s3 = provideTypography().s3,
        s4 = provideTypography().s4,
        s5 = provideTypography().s5,
        s6 = provideTypography().s6,
        s7 = provideTypography().s7,
        s8 = provideTypography().s8,
        t1 = provideTypography().t1,
        t2 = provideTypography().t2,
        t3 = provideTypography().t3,
        t4 = provideTypography().t4,
        t5 = provideTypography().t5
    )

    CompositionLocalProvider(
        localColorScheme provides colorScheme,
        localTypography provides typography,
        localDimens provides Dimens(),
        localRadius provides Radius(),
    ) {
        Box(modifier = Modifier.fillMaxSize().background(color = colorScheme.bg1)) {
            content()
        }
    }
}