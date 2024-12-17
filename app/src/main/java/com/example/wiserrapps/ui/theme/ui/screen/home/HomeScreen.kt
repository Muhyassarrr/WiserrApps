package com.example.wiserrapps.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wiserrapps.R
import com.example.wiserrapps.data.model.ProdukMangkok
import com.example.wiserrapps.data.model.Profiles
import com.example.wiserrapps.ui.navigation.Screen
import com.example.wiserrapps.ui.screen.home.component.Bangunan
import com.example.wiserrapps.ui.screen.home.component.Biaya
import com.example.wiserrapps.ui.screen.home.component.BiayaOprasional
import com.example.wiserrapps.ui.screen.home.component.HargaTerbaru
import com.example.wiserrapps.ui.screen.home.component.HasilProduksi
import com.example.wiserrapps.ui.screen.home.component.LaporanHasilBulanan
import com.example.wiserrapps.ui.screen.home.component.LaporanKeuanganBulanan
import com.example.wiserrapps.ui.screen.home.component.ListBulan
import com.example.wiserrapps.ui.screen.home.component.Produksi


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    profiles: Profiles,
    navController: NavController
) {
//    Box(
//        modifier = modifier.fillMaxSize()
//    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Halo " + profiles.nickname + "!",
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 24.sp,
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lgnotif),
                        contentDescription = "Notification Icon",
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Image(
                        painter = painterResource(id = profiles.photo),
                        contentDescription = "Profile Image",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .clickable {
                                navController.navigate(Screen.Profile.route)
                            }
                    )
                }
            }
            LazyColumn(
                contentPadding = PaddingValues(vertical = 5.dp),
                modifier = modifier
            ) {
                item {
                    val produkMangkok = ProdukMangkok(
                        "Mangkok Putih Kapas",
                        "Terakhir update Sabtu, 30 Oktober 2024",
                        "Rp.10.000.000",
                        "1 Kg",
                        R.drawable.produk1
                    )
                    HargaTerbaru(produkMangkok = produkMangkok, navController)
                }
                item {
                    Spacer(modifier=Modifier.height(15.dp))
                    Bangunan()
                }
                item {
                    ListBulan()
                }
                item {
                    Produksi()
                }
                item {
                    HasilProduksi()
                }
                item {
                    LaporanHasilBulanan(navController)
                }
                item {
                    Biaya()
                }
                item {
                    BiayaOprasional()
                }
                item {
                    LaporanKeuanganBulanan()
                }
            }
        }
    }
//}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        profiles = Profiles(
            id = 1,
            nama = "Brian Domani",
            nickname = "Brian",
            photo = R.drawable.ftbrian1
        ),
        navController = androidx.navigation.compose.rememberNavController() // Gunakan dummy NavController
    )
}
