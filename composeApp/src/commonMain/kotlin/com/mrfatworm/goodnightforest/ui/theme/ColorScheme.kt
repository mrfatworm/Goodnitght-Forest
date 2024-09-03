/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.ui.theme

import androidx.compose.ui.graphics.Color

data class ColorScheme (
    val primaryLight: Color = blue200,
    val primaryDefault: Color = blue500,
    val primaryDark: Color = blue700,
    val secondaryLight: Color = purple50,
    val secondaryDefault: Color = purple300,
    val secondaryDark: Color = purple500,
    val tertiaryLight: Color = orange100,
    val tertiaryDefault: Color = orange500,
    val tertiaryDark: Color = orange700,
    val successLight: Color = green50,
    val success: Color = green900,
    val warningLight: Color = yellow50,
    val warning: Color = yellow900,
    val dangerLight: Color = red50,
    val danger: Color = red900,
    val text1: Color = white900,
    val text2: Color = grey50,
    val text3: Color = grey100,
    val text4: Color = grey200,
    val buttonText: Color = white900,
    val bg1: Color = darkBlue1,
    val bg2: Color = darkBlue2,
    val bg3: Color = darkBlue3,
    val icon1: Color = white900
)