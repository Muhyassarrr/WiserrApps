package com.example.wiserrapps.ui.screen.harga.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wiserrapps.R
import com.example.wiserrapps.data.model.ProdukMangkok
import com.example.wiserrapps.data.model.ProdukOval
import com.example.wiserrapps.data.model.ProdukPatahan
import com.example.wiserrapps.data.model.ProdukSudut

@Composable
fun ProdukMangkokItem(
    produkMangkok: ProdukMangkok
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .border(1.dp, Color(0xFFBDBDBD), RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = produkMangkok.imageRes),
                contentDescription = produkMangkok.nama,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(produkMangkok.nama, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(produkMangkok.berat, color = Color.Gray, fontSize = 14.sp)
                Text(produkMangkok.harga, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text(produkMangkok.tanggal, color = Color.Gray, fontSize = 12.sp)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(thickness = 1.dp, color = Color(0xFFBDBDBD))
    }
}

@Composable
fun ProdukOvalItem(
    produkOval: ProdukOval
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .border(1.dp, Color(0xFFBDBDBD), RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = produkOval.imageRes),
                contentDescription = produkOval.nama,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(produkOval.nama, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(produkOval.berat, color = Color.Gray, fontSize = 14.sp)
                Text(produkOval.harga, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text(produkOval.tanggal, color = Color.Gray, fontSize = 12.sp)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(thickness = 1.dp, color = Color(0xFFBDBDBD))
    }
}

@Composable
fun ProdukSudutItem(
    produkSudut: ProdukSudut
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .border(1.dp, Color(0xFFBDBDBD), RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = produkSudut.imageRes),
                contentDescription = produkSudut.nama,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(produkSudut.nama, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(produkSudut.berat, color = Color.Gray, fontSize = 14.sp)
                Text(produkSudut.harga, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text(produkSudut.tanggal, color = Color.Gray, fontSize = 12.sp)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(thickness = 1.dp, color = Color(0xFFBDBDBD))
    }
}

@Composable
fun ProdukPatahanItem(
    produkPatahan: ProdukPatahan
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .border(1.dp, Color(0xFFBDBDBD), RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = produkPatahan.imageRes),
                contentDescription = produkPatahan.nama,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(produkPatahan.nama, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(produkPatahan.berat, color = Color.Gray, fontSize = 14.sp)
                Text(produkPatahan.harga, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text(produkPatahan.tanggal, color = Color.Gray, fontSize = 12.sp)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(thickness = 1.dp, color = Color(0xFFBDBDBD))
    }
}