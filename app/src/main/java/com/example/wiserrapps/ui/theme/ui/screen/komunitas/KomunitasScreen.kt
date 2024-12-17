package com.example.wiserrapps.ui.screen.komunitas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wiserrapps.ui.screen.komunitas.component.KomunitasPopular
import com.example.wiserrapps.ui.screen.komunitas.component.KomunitasRekomendasi
import com.example.wiserrapps.ui.screen.komunitas.component.KomunitasTopBar

@Composable
fun KomunitasScreen() {
    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp)
    ) {
        KomunitasTopBar()
        KomunitasPopular()
        KomunitasRekomendasi()
    }
}
@Preview(showBackground = true)
@Composable
fun KomunitasScreenPreview() {
    KomunitasScreen()
}