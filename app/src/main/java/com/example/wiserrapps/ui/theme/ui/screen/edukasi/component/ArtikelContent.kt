package com.example.wiserrapps.ui.theme.ui.screen.edukasi.component

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import coil.compose.rememberImagePainter
import com.example.wiserrapps.R
import com.example.wiserrapps.data.DataArtikel
import com.example.wiserrapps.data.model.Artikel
import com.example.wiserrapps.ui.theme.data.remote.response.ArticlessResponseItem

@Composable
fun ArtikelContent(
    Articles: List<ArticlessResponseItem>
){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = rememberImagePainter(
                data = R.drawable.artikel1,
                builder = {
                    crossfade(true) // Tambahkan transisi yang halus
                }
            ),
            contentDescription = "Background Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(370.dp),  // Adjusted for proper height
            contentScale = ContentScale.Crop
        )

        // Back Button
        IconButton(
            onClick = {  },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                modifier = Modifier.size(30.dp),
                contentDescription = "Back",
                tint = Color.Black
            )
        }

        // Content Box
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(570.dp)
                .background(Color.White, shape = RoundedCornerShape(40.dp))
                .padding(35.dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            // Row with tags
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(bottom = 10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 74.dp, height = 28.dp)
                        .background(color = Color(0xFFDCE8F3), shape = RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "5 Menit",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF17466E)
                    )
                }

                Spacer(modifier = Modifier.width(25.dp))

                Box(
                    modifier = Modifier
                        .size(width = 94.dp, height = 28.dp)
                        .background(color = Color(0xFFDCE8F3), shape = RoundedCornerShape(90.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "17 Okt 2024",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF17466E)
                    )
                }
            }

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Text(
                        text = "${Articles[0].title}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color(0xFF2B3A67),
                        textAlign = TextAlign.Left,
                        lineHeight = 30.sp
                    )
                }
                item {
                    Text(
                        text = "${Articles[0].content}",
                        textAlign = TextAlign.Justify,
                        fontSize = 13.sp,
                        lineHeight = 20.sp
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Sumber : \n" + "${Articles[0].desc}",
                        textAlign = TextAlign.Left,
                        fontSize = 12.sp,
                        lineHeight = 20.sp
                    )
                }
            }
        }
    }
}