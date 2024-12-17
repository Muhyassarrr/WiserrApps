package com.example.wiserrapps.ui.screen.home.component

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Produksi(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        Text(
            text = "Produksi",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(166.dp)
                    .height(85.dp)
                    .background(
                        Color(0xFFA3D0EE),
                        RoundedCornerShape(8.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            bottom = 15.dp,
                            start = 10.dp,
                            top = 7.dp
                        ),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total Panen diterima",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color(0xFF17466E),
                        ),
                        fontWeight = FontWeight.Bold

                    )
                    Text(
                        text = "0 Kg",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color(0xFF17466E),
                        ),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Box(
                modifier = Modifier
                    .width(166.dp)
                    .height(85.dp)
                    .background(
                        Color(0xFFA3D0EE),
                        RoundedCornerShape(8.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            bottom = 15.dp,
                            start = 10.dp,
                            top = 7.dp
                        ),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Dalam Proses",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color(0xFF17466E),
                        ),
                        fontWeight = FontWeight.Bold

                    )
                    Text(
                        text = "0 Kg",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color(0xFF17466E),
                        ),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ProduksiPreview(){
    Produksi()
}