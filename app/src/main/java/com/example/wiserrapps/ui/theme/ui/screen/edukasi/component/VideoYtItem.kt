package com.example.wiserrapps.ui.theme.ui.screen.edukasi.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wiserrapps.R
import com.example.wiserrapps.data.DataVideo
import com.example.wiserrapps.ui.theme.data.model.videoyt

@Composable
fun VideoYtItem(
    videoyt: videoyt
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
//            .clickable {
//                navController.navigate("videoscreen")
//            }
    ) {
        Image(
            painter = painterResource(id = videoyt.photo),
            contentDescription = "Gambaryt",
            modifier = Modifier
                .size(width = 72.89.dp, height = 75.31.dp)
                .clip(RoundedCornerShape(7.dp)),
            contentScale = ContentScale.Crop
        )

        // Teks di samping gambar
        Text(
            text = videoyt.judul,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        )
    }
    HorizontalDivider(
        modifier = Modifier
            .padding(top = 15.dp, bottom = 15.dp)
            .fillMaxWidth()
            .height(2.dp)
            .background(color = Color(0xFFA3D0EE)),
        thickness = 2.dp,
    )
}

@Composable
fun DetailVideoYtContent(
    videoytId: Int?,
){
    val videoytList = DataVideo.VideoPersiapan.filter { videoyt ->
        videoyt.id == videoytId
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .height(770.dp)
                .padding(20.dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .padding(5.dp)
                    .offset(x = -20.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    modifier = Modifier.size(30.dp),
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
        }
    }
    VideoYtContent(videoyt = videoytList)
}