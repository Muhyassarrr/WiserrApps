package com.example.wiserrapps.ui.theme.ui.screen.laporan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wiserrapps.ui.screen.home.component.Bangunan
import com.example.wiserrapps.ui.screen.home.component.ListBulan
import com.example.wiserrapps.ui.screen.home.component.Produksi
import com.example.wiserrapps.ui.screen.laporan.component.GrafikKeuangan
import com.example.wiserrapps.ui.screen.laporan.component.GrafikProduksi
import com.example.wiserrapps.ui.screen.laporan.component.TargetProduction
import com.example.wiserrapps.ui.theme.ui.screen.laporan.component.Riwayat
import com.example.wiserrapps.ui.theme.ui.screen.laporan.component.TargetKeuangan

@Composable
fun LaporanKeuaganScreen(
){
    Column {
        Box(
            modifier = Modifier
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .height(100.dp)
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .background(
                    color = Color(0xFF609AC1),
                    shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp),
                )
        ) {
            IconButton(
                onClick = { /*navController.popBackStack()*/},
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.size(40.dp),
                    tint = Color.White
                )
            }
            Text(
                text = "Laporan Keuangan",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Column (
            modifier = Modifier
                .padding(horizontal = 10.dp)
        ) {
            ListBulan()
            Produksi()
            Riwayat()
            TargetKeuangan()
            GrafikKeuangan()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview(){
    LaporanKeuaganScreen()
}