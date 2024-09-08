package com.mrfatworm.goodnightforest.ui.utils

import android.graphics.BlurMaskFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import androidx.compose.ui.graphics.NativePaint

internal actual fun NativePaint.blurMaskFilter(radius: Float, isDstOut: Boolean) {
    if (isDstOut) {
        xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
    }
    maskFilter = BlurMaskFilter(radius, BlurMaskFilter.Blur.NORMAL)
}