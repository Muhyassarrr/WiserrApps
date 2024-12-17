package com.example.wiserrapps.ui.screen.komunitas.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wiserrapps.R
import com.example.wiserrapps.data.model.komunitas
import com.example.wiserrapps.ui.screen.komunitas.component.CardPopular

@Composable
fun KomunitasPopular() {
    val komunitasList = listOf(
        komunitas("Pengusaha walet", "549 anggota", R.drawable.k1),
        komunitas("Budidaya walet", "511 anggota", R.drawable.k2),
    )

    Column(
        Modifier.fillMaxWidth()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Komunitas Populer",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            TextButton(
                onClick = {},
                colors = ButtonDefaults.textButtonColors(contentColor = Color(0xFF1B1919))
            ) {
                Text("Lihat semua")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            komunitasList.forEach { komunitas ->
                CardPopular(komunitas = komunitas)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewKomunitasPopular() {
    KomunitasPopular()
}
