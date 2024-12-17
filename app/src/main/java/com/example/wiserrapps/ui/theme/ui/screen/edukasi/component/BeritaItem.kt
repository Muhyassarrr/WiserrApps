package com.example.wiserrapps.ui.screen.edukasi.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wiserrapps.R
import com.example.wiserrapps.data.Data
import com.example.wiserrapps.data.DataBerita
import com.example.wiserrapps.data.model.Berita
import com.example.wiserrapps.ui.theme.ui.screen.edukasi.component.BeritaContent

@Composable
fun BeritaItem(
    berita: Berita,
    onItemClicked: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .width(354.dp)
            .height(183.dp)
            .clip(RoundedCornerShape(7.dp))
            .clickable {
                onItemClicked(berita.id)
            }
    ) {
        Image(
            painter = painterResource(id = berita.photo),
            contentDescription = "Gambar Berita",
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(7.dp)),
            contentScale = ContentScale.Crop
        )
        Text(
            text = berita.judul,
            fontSize = 20.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.TopCenter) // Ensure the text aligns properly
        )
    }
}
//@Preview(showBackground = true)
//@Composable
//private fun BeritaItemPreview() {
//    DetailBeritaScreen()
//}
@Composable
fun DetailBeritaScreen(
    navController: NavController,
    beritaId: Int?
) {
    val beritaList = DataBerita.berita.filter { berita ->
        berita.id == beritaId
    }
        Column {
            Box(
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0x40000000),
                        ambientColor = Color(0x40000000)
                    )
                    .height(100.dp)
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
                    .background(
                        color = Color(0xFF609AC1),
                        shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp),
                    )
            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(40.dp),
                        tint = Color.White
                    )
                }
                Text(
                    text = "Berita",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 10.dp)

            ) {
                BeritaContent(berita = beritaList)
            }
        }
    }



