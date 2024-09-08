package com.mrfatworm.goodnightforest.ui.utils

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.NativePaint
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Adds an inner shadow effect to the content.
 * ---
 * Ref:
 * [Medium/Kappdev](https://medium.com/@kappdev/inner-shadow-in-jetpack-compose-d80dcd56f6cf)
 */
fun Modifier.innerShadow(
    shape: Shape,
    color: Color = Color.Black,
    blur: Dp = 4.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp,
) = this.drawWithContent {
    val shadowSize = Size(size.width, size.height)
    val shadowOutline = shape.createOutline(shadowSize, layoutDirection, this)

    val basePaint = Paint()
    basePaint.color = Color.Black

    val shadowPaint = Paint()
    shadowPaint.color = color

    basePaint.asFrameworkPaint().apply {
        blurMaskFilter(blur.toPx(), true)
    }
    drawContent()

    drawIntoCanvas { canvas ->

        canvas.saveLayer((size).toRect(), shadowPaint)
        canvas.translate(offsetX.toPx(), offsetY.toPx())
        canvas.drawOutline(shadowOutline, shadowPaint)


        canvas.drawOutline(shadowOutline, basePaint)
        canvas.restore()
    }
}

fun Modifier.dropShadow(
    shape: Shape,
    color: Color = Color.Black.copy(0.25f),
    blur: Dp = 4.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp,
    spread: Dp = 0.dp
) = this.drawBehind {
    val shadowSize = Size(size.width + spread.toPx(), size.height + spread.toPx())
    val shadowOutline = shape.createOutline(shadowSize, layoutDirection, this)

    val paint = Paint()
    paint.color = color

    if (blur.toPx() > 0) {
        paint.asFrameworkPaint().apply {
            blurMaskFilter(blur.toPx(), false)
        }
    }

    drawIntoCanvas { canvas ->
        canvas.save()
        canvas.translate(offsetX.toPx() - (spread / 2).toPx(), offsetY.toPx() - (spread / 2).toPx())
        canvas.drawOutline(shadowOutline, paint)
        canvas.restore()
    }
}

internal expect fun NativePaint.blurMaskFilter(radius: Float, isDstOut: Boolean)