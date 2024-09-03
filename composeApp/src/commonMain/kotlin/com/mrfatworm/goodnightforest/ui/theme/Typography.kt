/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.noto_sans_tc_bold
import goodnitght_forest.composeapp.generated.resources.noto_sans_tc_medium
import goodnitght_forest.composeapp.generated.resources.noto_sans_tc_regular
import org.jetbrains.compose.resources.Font

data class Typography(
    val h0: TextStyle = TextStyle(),
    val h1: TextStyle = TextStyle(),
    val h2: TextStyle = TextStyle(),
    val h3: TextStyle = TextStyle(),
    val h4: TextStyle = TextStyle(),
    val h5: TextStyle = TextStyle(),
    val h6: TextStyle = TextStyle(),
    val h7: TextStyle = TextStyle(),
    val s1: TextStyle = TextStyle(),
    val s2: TextStyle = TextStyle(),
    val s3: TextStyle = TextStyle(),
    val s4: TextStyle = TextStyle(),
    val s5: TextStyle = TextStyle(),
    val s6: TextStyle = TextStyle(),
    val s7: TextStyle = TextStyle(),
    val s8: TextStyle = TextStyle(),
    val t1: TextStyle = TextStyle(),
    val t2: TextStyle = TextStyle(),
    val t3: TextStyle = TextStyle(),
    val t4: TextStyle = TextStyle(),
    val t5: TextStyle = TextStyle()
)

@Composable
fun provideTypography(): Typography {
    val noToSansTc = FontFamily(
        Font(Res.font.noto_sans_tc_regular, FontWeight.Normal),
        Font(Res.font.noto_sans_tc_medium, FontWeight.Medium),
        Font(Res.font.noto_sans_tc_bold, FontWeight.Bold)
    )

    return Typography(
        h0 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Bold,
            fontSize = 56.sp,
            lineHeight = 70.sp
        ),
        h1 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            lineHeight = 56.sp
        ),
        h2 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            lineHeight = 40.sp
        ),
        h3 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            lineHeight = 35.sp
        ),
        h4 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            lineHeight = 30.sp
        ),
        h5 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            lineHeight = 22.5.sp
        ),
        h6 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            lineHeight = 20.sp
        ),
        h7 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            lineHeight = 17.5.sp
        ),
        s1 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Medium,
            fontSize = 32.sp,
            lineHeight = 40.sp
        ),
        s2 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Medium,
            fontSize = 28.sp,
            lineHeight = 35.sp
        ),
        s3 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            lineHeight = 30.sp
        ),
        s4 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            lineHeight = 22.5.sp
        ),
        s5 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 20.sp
        ),
        s6 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 17.5.sp
        ),
        s7 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            lineHeight = 15.sp
        ),
        s8 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
            lineHeight = 12.5.sp
        ),
        t1 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            lineHeight = 25.2.sp
        ),
        t2 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 22.4.sp
        ),
        t3 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 19.6.sp
        ),
        t4 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 16.8.sp
        ),
        t5 = TextStyle(
            fontFamily = noToSansTc,
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp,
            lineHeight = 14.sp
        )
    )
}