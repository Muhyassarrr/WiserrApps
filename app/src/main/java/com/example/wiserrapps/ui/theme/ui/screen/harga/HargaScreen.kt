package com.example.wiserrapps.ui.screen.harga

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wiserrapps.data.DataProduk
import com.example.wiserrapps.data.model.ProdukMangkok
import com.example.wiserrapps.data.model.ProdukOval
import com.example.wiserrapps.data.model.ProdukPatahan
import com.example.wiserrapps.data.model.ProdukSudut
import com.example.wiserrapps.ui.screen.harga.component.ProdukMangkokItem
import com.example.wiserrapps.ui.screen.harga.component.ProdukOvalItem
import com.example.wiserrapps.ui.screen.harga.component.ProdukPatahanItem
import com.example.wiserrapps.ui.screen.harga.component.ProdukSudutItem

@Composable
fun HargaScreen(
    navController: NavController,
    produkMangkok: List<ProdukMangkok> = DataProduk.ProdukMangkok,
    produkPatahan: List<ProdukPatahan> = DataProduk.ProdukPatahan,
    produkSudut: List<ProdukSudut> = DataProduk.ProdukSudut,
    produkOval: List<ProdukOval> = DataProduk.ProdukOval,
){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(
                    Color(color = 0xFF609AC1),
                    RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Detail Harga Terbaru",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
            )
        }
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(20.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                modifier = Modifier.size(35.dp),
                contentDescription = "Back",
                tint = Color.White
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                item {
                    Text("Bentuk Mangkok", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(vertical = 8.dp))
                }
                items(produkMangkok){ produkMangkok ->
                    ProdukMangkokItem(produkMangkok)
                }
                item {
                    Text("Bentuk Oval", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(vertical = 8.dp))
                }
                items(produkOval){ produkOval ->
                    ProdukOvalItem(produkOval)
                }
                item {
                    Text("Bentuk Patahan", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(vertical = 8.dp))
                }
                items(produkPatahan) {produkPatahan ->
                    ProdukPatahanItem(produkPatahan)
                }
                item {
                    Text("Bentuk Sudut", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(vertical = 8.dp))
                }
                items(produkSudut) {produkSudut ->
                    ProdukSudutItem(produkSudut)
                }
            }
        }
    }
}
