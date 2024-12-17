package com.example.wiserrapps.utils

import com.example.wiserrapps.ui.navigation.Screen


fun String?.shouldShowBottomBar(): Boolean {
    return this in setOf(
        Screen.Home.route,
        Screen.Edukasi.route,
        Screen.Komunitas.route,
        Screen.Konsultasi.route
    )
}

fun String?.shouldShowFloatingActionBar(): Boolean {
    return this in setOf(
        Screen.Home.route
    )
}