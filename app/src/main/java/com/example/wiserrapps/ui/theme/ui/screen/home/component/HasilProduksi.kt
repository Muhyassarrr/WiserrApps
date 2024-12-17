package com.example.wiserrapps.ui.screen.home.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
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

@Composable
fun HasilProduksi(){
    Column (
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
            ),
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween // This ensures that the column is on the left and the circle is on the right
        ) {
            Text(
                text = "Hasil produksi bulan September",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row  (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ){
            Column {
                Row (
                    modifier = Modifier
                        .height(25.dp)
                        .width(180.dp)
                        .padding(horizontal = 10.dp)
                        .background(
                            Color(0xFF266EA6),
                            RoundedCornerShape(8.dp)
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Mangkok",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(start = 5.dp)
                    )
                    Text(
                        text = "0 kg",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(end = 5.dp)
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))

                Row (
                    modifier = Modifier
                        .height(25.dp)
                        .width(180.dp)
                        .padding(horizontal = 10.dp) // Menambahkan padding horizontal agar teks tidak terlalu dekat dengan tepi
                        .background(
                            Color(0xFF2E85C8),
                            RoundedCornerShape(8.dp)
                        ), // Memastikan Row berada di tengah Box
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Sudut",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(start = 5.dp)
                    )
                    Text(
                        text = "0 kg",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(end = 5.dp)
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row (
                    modifier = Modifier
                        .height(25.dp)
                        .width(180.dp)
                        .padding(horizontal = 10.dp) // Menambahkan padding horizontal agar teks tidak terlalu dekat dengan tepi
                        .background(
                            Color(0xFF4D9EDB),
                            RoundedCornerShape(8.dp)
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Oval",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(start = 5.dp)
                    )
                    Text(
                        text = "0 kg",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(end = 5.dp)
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))

                Row (
                    modifier = Modifier
                        .height(25.dp)
                        .width(180.dp)
                        .padding(horizontal = 10.dp) // Menambahkan padding horizontal agar teks tidak terlalu dekat dengan tepi
                        .background(
                            Color(0xFF7CB5E1),
                            RoundedCornerShape(8.dp)
                        ), // Memastikan Row berada di tengah Box
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Patahan",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(start = 5.dp)
                    )
                    Text(
                        text = "0 kg",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(end = 5.dp)

                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row (
                    modifier = Modifier
                        .height(25.dp)
                        .width(180.dp)
                        .padding(horizontal = 10.dp) // Menambahkan padding horizontal agar teks tidak terlalu dekat dengan tepi
                        .background(
                            color = Color.Transparent,
                            RoundedCornerShape(8.dp)
                        ), // Memastikan Row berada di tengah Box
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Total",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(start = 5.dp)
                    )
                    Text(
                        text = "0 kg",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(end = 5.dp)


                    )
                }
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(110.dp)
            ) {
                Canvas(modifier = Modifier
                    .fillMaxSize()
                )
                {
                    drawCircle(
                        color = Color(0xFFD6E1EE),
                        radius = size.minDimension / 2
                    )
                    drawCircle(
                        color = Color.White,
                        radius = size.minDimension / 3
                    )
                    drawCircle(
                        color = Color(0xFFD6E1EE),
                        radius = size.minDimension / 4
                    )
                }
                BasicText(
                    text = "0 Kg",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontSize = 15.sp,
                        color = Color.Black
                    )
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun HasilPrioduksiPreview(){
    HasilProduksi()
}