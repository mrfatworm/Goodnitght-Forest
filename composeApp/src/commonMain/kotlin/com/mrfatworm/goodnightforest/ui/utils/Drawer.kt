/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.ui.utils

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.Dp


fun DrawScope.drawDashBoardProgress(
    angleSize: Float, brush: Brush, percentage: Float, strokeWidth: Dp
) {
    // start from the bottom
    val startAngle = 270 - (angleSize / 2)
    val sweepAngle = angleSize * percentage
    val stroke = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)

    drawArc(
        startAngle = startAngle,
        sweepAngle = sweepAngle,
        useCenter = false,
        brush = brush,
        style = stroke
    )
}

fun DrawScope.drawDashBoardLines(
    angleSize: Float,
    linesAmount: Int,
    color: Color = Color.White,
    lineLength: Float = 16f,
    padding: Float = 36f
) {
    val perRotation = angleSize / linesAmount
    // start from the top
    val startAngle = 90 - angleSize / 2
    val centerY = size.height / 2

    for (i in 0..linesAmount) {
        rotate(i * perRotation + startAngle) {
            drawLine(
                color = color,
                start = Offset(x = padding, y = centerY),
                end = Offset(x = lineLength + padding, y = centerY),
                strokeWidth = 1f
            )
        }
    }
}

@Composable
fun TrapezoidCanvas(modifier: Modifier, shapeColor: Color) {
    Canvas(modifier = modifier) {
        val trianglePath = Path().apply {
            moveTo(0f, 0f)
            lineTo(size.width * 0.8f, 0f)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }
        //補上左側圓角
        val rectanglePath = Path().apply {
            moveTo(0f, 0f)
            lineTo(size.width * 0.50f, 0f)
            lineTo(size.width * 0.8f, size.height)
            lineTo(0f, size.height)
            close()
        }
        //補上右下圓角
        val lowTrianglePath = Path().apply {
            moveTo(0f, size.height * 0.5f)
            lineTo(size.width * 0.9f, size.height * 0.5f)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }

        drawIntoCanvas { canvas ->
            canvas.drawOutline(
                outline = Outline.Generic(trianglePath),
                paint = Paint().apply {
                    color = shapeColor
                    pathEffect = PathEffect.cornerPathEffect(64f)
                }
            )
            canvas.drawPath(rectanglePath, Paint().apply { color = shapeColor })
            canvas.drawPath(lowTrianglePath, Paint().apply { color = shapeColor })
        }
    }
}