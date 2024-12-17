package com.example.wiserrapps.ui.screen.konusltasi.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wiserrapps.R
import com.example.wiserrapps.data.model.populerkonsultasi
import com.example.wiserrapps.data.model.riwayatkonsultasi

@Composable
fun CardKonsultasiRow(
    riwayatkonsultasi: riwayatkonsultasi
) {
    Box(
        modifier = Modifier
            .width(226.dp)
            .height(131.dp)
            .shadow(
                elevation = 8.dp, // Tinggi bayangan
                shape = RoundedCornerShape(8.dp), // Bentuk shadow mengikuti bentuk latar
                clip = true // Memotong Box agar shadow mengikuti bentuk RoundedCornerShape
            )
            .background(
                color = Color(0xFFDCE8F3),
                shape = RoundedCornerShape(8.dp) // Bentuk latar belakang
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(100.dp)
                    .padding(vertical = 10.dp)
                    .padding(start = 10.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = riwayatkonsultasi.nama,
                    fontSize = 15.sp,
                    color = Color(0xFF17466E),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )
                Image(
                    painter = painterResource(id = riwayatkonsultasi.rate),
                    contentDescription = "Rating Icon",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(19.dp)
                )
                Text(
                    text = riwayatkonsultasi.tanggal,
                    fontSize = 15.sp,
                    color = Color(0xFF17466E),
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Text(
                    text = riwayatkonsultasi.online,
                    fontSize = 15.sp,
                    color = Color(0xFF17466E),
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            Image(
                painter = painterResource(id = riwayatkonsultasi.photo),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(93.dp)
                    .clip(CircleShape)
            )
        }
    }
}

@Composable
fun CardKonsulColumn(
    populerkonsultasi: populerkonsultasi
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(139.dp)
            .shadow(
                elevation = 8.dp, // Menentukan tinggi bayangan
                shape = RoundedCornerShape(8.dp), // Bentuk shadow mengikuti RoundedCornerShape
                clip = false // Jangan memotong view dengan shadow
            )
            .background(
                color = Color(0xFFDCE8F3),
                shape = RoundedCornerShape(8.dp)
            )
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = populerkonsultasi.photo),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(110.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(start = 5.dp, top = 10.dp, bottom = 10.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = populerkonsultasi.nama,
                        fontSize = 15.sp,
                        color = Color(0xFF17466E),
                        fontWeight = FontWeight.Bold,
                    )
                    Image(
                        painter = painterResource(id = populerkonsultasi.rate),
                        contentDescription = "Notification Icon",
                        modifier = Modifier
                            .width(76.dp)
                            .height(17.dp)
                    )
                }
                Text(
                    text = populerkonsultasi.asal,
                    fontSize = 15.sp,
                    color = Color(0xFF17466E),
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .fillMaxWidth()

                )
                Text(
                    text = populerkonsultasi.tanggal,
                    fontSize = 15.sp,
                    color = Color(0xFF17466E),
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Text(
                    text = populerkonsultasi.online,
                    fontSize = 15.sp,
                    color = Color(0xFF17466E),
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun CardKonsultasiColumnPreview() {
    CardKonsulColumn(
        populerkonsultasi = populerkonsultasi(
            1,
            "Muh. Yassar",
            online = "5 Menit",
            "Pakar Sarang Burung Walet Makassar",
            tanggal = "10/10/2024",
            rate = R.drawable.rate4star,
            photo = R.drawable.konsul1
        )
    )
}