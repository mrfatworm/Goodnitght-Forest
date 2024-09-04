package com.mrfatworm.goodnightforest.ui.utils

import androidx.compose.ui.graphics.NativePaint
import org.jetbrains.skia.BlendMode
import org.jetbrains.skia.FilterBlurMode
import org.jetbrains.skia.MaskFilter

internal actual fun NativePaint.blurMaskFilter(radius: Float) {
    blendMode = BlendMode.DST_OUT
    this.maskFilter = MaskFilter.makeBlur(FilterBlurMode.NORMAL, radius / 2, true)
}