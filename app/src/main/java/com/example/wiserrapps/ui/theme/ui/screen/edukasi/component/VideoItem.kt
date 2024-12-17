package com.example.wiserrapps.ui.screen.edukasi.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.wiserrapps.R
import com.example.wiserrapps.data.DataBerita
import com.example.wiserrapps.data.DataVideo
import com.example.wiserrapps.data.model.video
import com.example.wiserrapps.ui.theme.ui.screen.edukasi.component.VideoContentt


@Composable
fun VideoItem(
    video: video,
    onItemClicked: (Int) -> Unit
){
    Column (
        Modifier
            .width(295.dp)
            .height(215.dp)
            .background(color = Color (0xFF609AC1), RoundedCornerShape(8.dp))
            .clickable {
                onItemClicked(video.id)
            },
        ){
        Image(
            painter = painterResource(id = video.photo),
            contentDescription = "Gambar Video",
            modifier = Modifier
                .fillMaxWidth()
                .height(136.dp)
                .clip(RoundedCornerShape(7.dp)),
            contentScale = ContentScale.Crop
        )
        Text(
            text = video.judul,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(10.dp),
            color = Color.White
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun VideoItemPreview(){
//    VideoItem(
//        video(
//           1,
//           "Persiapan Awal Budidaya Sarang Burung Walet",
//           "Tahap persiapan awal membahas dasar-dasar budidaya sarang burung walet, mulai dari pemilihan lokasi yang strategis hingga persiapan bangunan yang sesuai dengan kebutuhan burung walet.",
//           R.drawable.video1
//       )
//    )
//}

@Composable
fun DetailVideoScreen(
    videoId: Int?,
    navController: NavController
) {
    val videoList = DataVideo.Video.filter { video ->
        video.id == videoId
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
            val navController = rememberNavController()
            VideoContentt(video = videoList,
                navController = navController)
        }
    }
}
