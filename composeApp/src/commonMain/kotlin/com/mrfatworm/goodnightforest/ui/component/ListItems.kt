package com.mrfatworm.goodnightforest.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mrfatworm.goodnightforest.ui.component.data.LessonListItemState
import com.mrfatworm.goodnightforest.ui.theme.AppTheme
import com.mrfatworm.goodnightforest.ui.theme.blue200
import com.mrfatworm.goodnightforest.ui.utils.conditional
import com.mrfatworm.goodnightforest.ui.utils.dropShadow
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource


@Composable
fun LessonListItem(
    uiState: LessonListItemState, onClick: () -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }
    var selected by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Surface(
            modifier = Modifier.clickable(interactionSource = interactionSource,
                indication = ripple(radius = 16.dp),
                onClick = {
                    selected = !selected
                    onClick()
                }),
            shape = RoundedCornerShape(16.dp),
            color = if (selected) AppTheme.colors.bg2 else AppTheme.colors.bg3,
            border = if (selected) BorderStroke(
                width = 1.dp, color = AppTheme.colors.primaryLight
            ) else null
        ) {
            Icon(
                modifier = Modifier
                    .padding(18.dp)
                    .size(36.dp)
                    .conditional(selected) {
                        dropShadow(
                            shape = CircleShape,
                            color = Color(0xCCD6D0F5),
                            blur = 16.dp,
                            spread = -(8.dp)
                        )
                    },
                imageVector = vectorResource(uiState.iconRes),
                contentDescription = null,
                tint = if (selected) blue200 else AppTheme.colors.primaryLight
            )
        }
        Text(
            text = stringResource(uiState.textRes),
            color = AppTheme.colors.text2,
            style = AppTheme.typography.t4
        )

    }
}