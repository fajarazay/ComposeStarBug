package com.fajarazay.github.composestarbuck.ui.component

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.fajarazay.github.composestarbuck.ui.theme.SelectedIndicatorColor
import com.fajarazay.github.composestarbuck.ui.theme.UnselectIndicatorColor

@Composable
fun CarouselIndicator(size: Int, currentPage: Int) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        repeat(size) {
            DotsIndicator(isSelected = it == currentPage)
        }
    }
}

@Composable
fun DotsIndicator(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 25.dp else 12.dp)

    Box(
        modifier = Modifier
            .padding(1.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) SelectedIndicatorColor else UnselectIndicatorColor
            )
    )
}
