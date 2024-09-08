/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.ui.utils

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
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