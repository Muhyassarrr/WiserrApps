package com.example.wiserrapps.ui.theme.ui.screen.onboarding.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PagerIndicator(currentPage: Int, totalPages: Int) {
    Row {
        repeat(totalPages) { index ->
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(
                        if (index == currentPage) Color.Black else Color.Gray,
                        shape = RoundedCornerShape(50)
                    )
            )
            if (index != totalPages - 1) {
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}
