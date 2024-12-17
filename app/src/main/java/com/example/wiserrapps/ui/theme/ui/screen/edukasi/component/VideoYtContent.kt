package com.example.wiserrapps.ui.theme.ui.screen.edukasi.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.wiserrapps.R
import com.example.wiserrapps.data.DataVideo
import com.example.wiserrapps.ui.theme.data.model.videoyt

@Composable
fun VideoYtContent(
    videoyt: List<videoyt> = DataVideo.VideoPersiapan
){
    Column {
        Image(
            painter = rememberImagePainter(
                data = videoyt[0].photo,
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = "Gambar Berita",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(7.dp)),
            contentScale = ContentScale.Crop
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
        ) {
            Text(
                text = "${videoyt[0].judul}",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Left,
                lineHeight = 24.sp,
                modifier = Modifier.weight(1f)
            )

            val isFavorited = remember { mutableStateOf(false) }
            val favImage = if (isFavorited.value) {
                painterResource(id = R.drawable.glg)
            } else {
                painterResource(id = R.drawable.fav)
            }

            Box(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(30.dp)
            ) {
                IconButton(
                    onClick = {
                        isFavorited.value = !isFavorited.value
                    },
                    modifier = Modifier
                        .size(30.dp)
                        .animateContentSize(animationSpec = tween(durationMillis = 300))
                ) {
                    Image(
                        painter = favImage,
                        contentDescription = "Tombol favorit",
                        modifier = Modifier
                            .padding(1.dp)
                            .width(25.33333.dp)
                            .height(30.175.dp)
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(
                    Color(0xFFDCE8F3),
                    (RoundedCornerShape(7.dp))
                ),
            contentAlignment = Alignment.TopStart
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
            ) {
                Text(
                    text = "Deskripsi",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF17466E),
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "${videoyt[0].deskripsi}",
                    style = TextStyle(
                        fontSize = 13.sp,
                        lineHeight = 19.5.sp,
//                            fontWeight = FontWeight,
                        color = Color(0xFF1B1919),
                        textAlign = TextAlign.Justify
                    )
                )
            }
        }
    }
}