package com.example.wiserrapps.ui.theme.ui.screen.laporan.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Riwayat(){
    Column{
        Text(
            text = "Riwayat",
            color = Color.Black,
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold),
        )
        RiwayatPemasukan()
    }
}

@Composable
fun RiwayatPemasukan(){
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Pengeluaran", "Pemasukan")

    Column {
        TabRow(
            selectedTabIndex = selectedTab, // Warna latar belakang untuk TabRow
            contentColor = Color.Black     // Warna konten default
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = {
                        Text(
                            text = title,
                            fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Normal,
                            color = if (selectedTab == index) Color.Black else Color.Gray // Warna teks
                        )
                    }
                )
            }
        }

        // Konten sesuai tab yang dipilih
        when (selectedTab) {
            0 -> Pengeluaran() // Pastikan composable Pengeluaran() terdefinisi
            1 -> Pemasukan()   // Pastikan composable Pemasukan() terdefinisi
        }
    }
}
@Composable
fun Pengeluaran() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .shadow(
                elevation = 4.dp, // Sesuaikan dengan ketebalan bayangan yang diinginkan
                shape = RoundedCornerShape(8.dp), // Mengikuti bentuk rounded corner
                clip = false // Atur apakah bayangan mengikuti bentuk atau tidak
            )
            .background(
                color = Color(0xFFFFFFFF), // Warna putih untuk background
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        PengeluaranItem()
        PengeluaranItem()
        PengeluaranItem()
    }
}
@Composable
fun PengeluaranItem(){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "Back",
                    modifier = Modifier.size(25.dp),
                    tint = Color.Red
                )
                Column {
                    Text(
                        text = "Parfum",
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 21.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1B1919),
                        )
                    )
                    Text(
                        text = "Parfum Paketan ",
                        style = TextStyle(
                            fontSize = 11.sp,
                            lineHeight = 16.5.sp,
                            fontWeight = FontWeight.Light,
                            color = Color(0xFF1B1919),
                        )
                    )
                }
            }
            Column {
                Text(
                    text = "Rp.500.000,00",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1B1919),
                    )
                )
                Text(
                    text = "24 September 2024",
                    style = TextStyle(
                        fontSize = 11.sp,
                        lineHeight = 16.5.sp,
                        fontWeight = FontWeight.Light,
                        color = Color(0xFF1B1919),
                    )
                )
            }
        }
    }

@Composable
fun Pemasukan(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .shadow(
                elevation = 4.dp, // Sesuaikan dengan ketebalan bayangan yang diinginkan
                shape = RoundedCornerShape(8.dp), // Mengikuti bentuk rounded corner
                clip = false // Atur apakah bayangan mengikuti bentuk atau tidak
            )
            .background(
                color = Color(0xFFFFFFFF), // Warna putih untuk background
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        PemasukanItem()
        PemasukanItem()
        PemasukanItem()
    }
}
@Composable
fun PemasukanItem(){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Icon(
                    imageVector = Icons.Filled.ArrowDropUp,
                    contentDescription = "Back",
                    modifier = Modifier.size(25.dp),
                    tint = Color.Green
                )
                Column {
                    Text(
                        text = "Parfum",
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 21.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1B1919),
                        )
                    )
                    Text(
                        text = "Parfum Paketan ",
                        style = TextStyle(
                            fontSize = 11.sp,
                            lineHeight = 16.5.sp,
                            fontWeight = FontWeight.Light,
                            color = Color(0xFF1B1919),
                        )
                    )
                }
            }
            Column {
                Text(
                    text = "Rp.500.000,00",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1B1919),
                    )
                )
                Text(
                    text = "24 September 2024",
                    style = TextStyle(
                        fontSize = 11.sp,
                        lineHeight = 16.5.sp,
                        fontWeight = FontWeight.Light,
                        color = Color(0xFF1B1919),
                    )
                )
            }
        }
    }





@Preview(showBackground = true)
@Composable
fun Preview(){
    RiwayatPemasukan()
}