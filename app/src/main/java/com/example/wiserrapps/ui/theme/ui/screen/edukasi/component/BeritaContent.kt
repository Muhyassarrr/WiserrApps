package com.example.wiserrapps.ui.theme.ui.screen.edukasi.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.wiserrapps.R
import com.example.wiserrapps.data.DataBerita
import com.example.wiserrapps.data.model.Berita

@Composable
fun BeritaContent(
    berita: List<Berita> = DataBerita.berita
){
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                text = "${berita[0].judul}",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Left,
            )
        }
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(bottom = 10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 115.dp, height = 28.dp)
                        .background(color = Color(0xFFDCE8F3), shape = RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "${berita[0].pembuat}",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF17466E),
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Box(
                    modifier = Modifier
                        .size(width = 94.dp, height = 28.dp)
                        .background(color = Color(0xFFDCE8F3), shape = RoundedCornerShape(90.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "${berita[0].tanggal}",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF17466E)
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))

                Box(
                    modifier = Modifier
                        .size(width = 74.dp, height = 22.dp)
                        .background(color = Color(0xFFDCE8F3), shape = RoundedCornerShape(90.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "${berita[0].tanggal}",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF17466E)
                    )
                }

                val isFavorited = remember { mutableStateOf(false) }
                val favImage = if (isFavorited.value) {
                    painterResource(id = R.drawable.glg)
                } else {
                    painterResource(id = R.drawable.fav)
                }

                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(
                        onClick = {
                            isFavorited.value = !isFavorited.value
                        },
                        modifier = Modifier.align(Alignment.TopEnd)
                    ) {
                        Image(
                            painter = favImage,
                            contentDescription = "Tombol favorit",
                            modifier = Modifier
                                .padding(1.dp)
                                .width(25.33333.dp)
                                .height(30.175.dp)
                                .animateContentSize(animationSpec = tween(durationMillis = 300)) // Animasi perubahan ukuran
                        )
                    }
                }
            }
        }
        item {
            Text(
                text = "${berita[0].headline}",
                fontSize = 14.sp,
                textAlign = TextAlign.Justify,
                lineHeight = 17.sp
            )
        }
        item {
            Image(
                painter = rememberImagePainter(
                    data = berita[0].photo,
                    builder = {
                        crossfade(true) // Tambahkan transisi yang halus
                    }
                ),
                contentDescription = "Gambar Berita",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(187.dp)
                    .clip(RoundedCornerShape(7.dp)),
                contentScale = ContentScale.Crop
            )
        }
        item {
            Text(
                text = "${berita[0].isi}",
                fontSize = 14.sp,
                textAlign = TextAlign.Justify,
                lineHeight = 20.sp
            )
        }
        item {
            Text(
                text = "Sumber : ${berita[0].sumber} \n" ,
                textAlign = TextAlign.Left,
                fontSize = 13.sp,
                lineHeight = 20.sp
            )
        }
    }
}