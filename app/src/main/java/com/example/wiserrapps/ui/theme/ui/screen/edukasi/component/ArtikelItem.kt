package com.example.wiserrapps.ui.screen.edukasi.component

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.wiserrapps.R
import com.example.wiserrapps.data.DataArtikel
import com.example.wiserrapps.ui.theme.data.remote.ArticleRepositoryImpl
import com.example.wiserrapps.ui.theme.data.remote.RetrofitInstance
import com.example.wiserrapps.ui.theme.data.remote.response.ArticleViewModel
import com.example.wiserrapps.ui.theme.data.remote.response.ArticlessResponseItem
import com.example.wiserrapps.ui.theme.ui.screen.edukasi.component.ArtikelContent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ArtikelItem(
    artikel: ArticlessResponseItem,
    onItemClicked: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(187.dp)
            .padding(vertical = 10.dp)
            .clickable {
                onItemClicked(artikel?.id ?:0)
            }
            .background(Color(0xFFA3D0EE), RoundedCornerShape(8.dp))
    ) {
        Row(modifier = Modifier.fillMaxWidth())
        {
            Column(
                modifier = Modifier
                .padding(start = 10.dp, top = 20.dp, end = 20.dp, bottom = 20.dp))
            {
                Row(
                    modifier = Modifier
                    .width(214.dp))
                {
                    Text(
                        text = "${artikel.title}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(lineHeight = 20.sp)
                    )
                }
                Row(
                    modifier = Modifier
                        .width(214.dp)
                ) {
                    Text(
                        text = "${artikel.desc}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Normal,
                        style = TextStyle(lineHeight = 15.sp),
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }
            }
            // Assuming artikel.photo is a valid image resource ID or a URL
            Image(
                painter = painterResource(id = R.drawable.artikel1), // Ensure that `artikel.photo` is correct
                contentDescription = "Gambar Video",
                modifier = Modifier.clip(RoundedCornerShape(7.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun DetailArtikelScreen(
    navController: NavController,
    artikelId: Int?
){
    val artikelList = DataArtikel.artikel.filter { artikel ->
        artikel.id == artikelId
    }
    ArtikelContent(Articles = artikelList)
}
