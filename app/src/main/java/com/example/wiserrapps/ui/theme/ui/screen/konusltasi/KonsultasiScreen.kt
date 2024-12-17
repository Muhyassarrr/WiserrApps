package com.example.wiserrapps.ui.screen.konusltasi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wiserrapps.R
import com.example.wiserrapps.data.DataKonsultasi
import com.example.wiserrapps.data.model.Profiles
import com.example.wiserrapps.data.model.populerkonsultasi
import com.example.wiserrapps.data.model.riwayatkonsultasi
import com.example.wiserrapps.ui.screen.konusltasi.component.CardKonsulColumn
import com.example.wiserrapps.ui.screen.konusltasi.component.CardKonsultasiRow
import com.example.wiserrapps.ui.screen.konusltasi.component.KonsultasiTopBar


@Composable
fun KonsultasiScreen(
    navController: NavController,
    profiles: Profiles,
    riwayatkonsultasi:List<riwayatkonsultasi> = DataKonsultasi.RiwayatKonsultasi,
    populerkonsultasi:List<populerkonsultasi> = DataKonsultasi.PopulerKonsultasi
){
    Column {
        KonsultasiTopBar(profiles = profiles)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 13.dp, end = 20.dp, bottom = 13.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Riawayat",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Filled.List,
                contentDescription = "Send Icon",
                tint = Color(0xFF17466E),
            )
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(riwayatkonsultasi, key = {it.id}){
                CardKonsultasiRow(riwayatkonsultasi = it)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 13.dp, end = 20.dp, bottom = 13.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Populer",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(populerkonsultasi, key = {it.id}){
                CardKonsulColumn(populerkonsultasi = it)
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun KonsultasiPagePreview() {
//    KonsultasiScreen(
//        profiles = Profiles(
//            id = 1,
//            nama = "Brian",
//            nickname = "Brian",
//            photo = R.drawable.ftbrian1
//        ),
//    )
//}
