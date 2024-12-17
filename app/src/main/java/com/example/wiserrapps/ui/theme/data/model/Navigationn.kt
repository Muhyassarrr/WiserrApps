package com.example.wiserrapps.data.model

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.wiserrapps.ui.navigation.Screen

data class NavigationItem(
    val title: String,
    val icon: Int,
    val screen: Screen
)