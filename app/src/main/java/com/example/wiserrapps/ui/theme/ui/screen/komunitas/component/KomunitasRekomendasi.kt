package com.example.wiserrapps.ui.screen.komunitas.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wiserrapps.data.Data
import com.example.wiserrapps.data.model.komunitas
import com.example.wiserrapps.ui.screen.komunitas.component.CardRekomendasi

@Composable
fun KomunitasRekomendasi(
    komunitas: List<komunitas> = Data.Komunitas
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Direkomendasikan",
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

        Spacer(modifier = Modifier.height(8.dp))

        // Using LazyColumn for scrolling
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(komunitas) { komunitas ->
                CardRekomendasi(komunitas)
            }
        }
    }
}