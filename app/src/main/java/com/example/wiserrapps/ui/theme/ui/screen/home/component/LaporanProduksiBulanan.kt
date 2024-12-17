package com.example.wiserrapps.ui.screen.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wiserrapps.R

@Composable
fun LaporanHasilBulanan(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(vertical = 10.dp)
            .background(
                Color(0xFF609AC1),
                RoundedCornerShape(8.dp)
            )
            .clickable {
                navController.navigate("lapproduksi")
            },
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Laporan Produksi \n" +
                        "Bulanan",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color(0xFFFFFFFF),
                ),
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(id = R.drawable.laporanproduksi),
                contentDescription = "icon home",
                modifier = Modifier
                    .size(65.dp)
            )
        }
    }
}
