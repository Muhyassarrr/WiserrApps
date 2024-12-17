package com.example.wiserrapps.ui.screen.edukasi


import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wiserrapps.ui.screen.edukasi.component.VideoItem
import com.example.wiserrapps.data.DataArtikel
import com.example.wiserrapps.data.DataBerita
import com.example.wiserrapps.data.DataVideo
import com.example.wiserrapps.data.model.Artikel
import com.example.wiserrapps.data.model.Berita
import com.example.wiserrapps.data.model.video
import com.example.wiserrapps.ui.navigation.Screen
import com.example.wiserrapps.ui.screen.edukasi.component.ArtikelItem
import com.example.wiserrapps.ui.screen.edukasi.component.BeritaItem
import com.example.wiserrapps.ui.screen.edukasi.component.EdukasiTopBar
import com.example.wiserrapps.ui.theme.data.remote.ArticleRepositoryImpl
import com.example.wiserrapps.ui.theme.data.remote.RetrofitInstance
import com.example.wiserrapps.ui.theme.data.remote.response.ArticleViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun EdukasiScreen(
    navController: NavController,
    berita: List<Berita> = DataBerita.berita,
    video: List<video> = DataVideo.Video,
) {
    val viewModel: ArticleViewModel = viewModel(factory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ArticleViewModel(ArticleRepositoryImpl(RetrofitInstance.api)) as T
        }
    })

    // Collect state from ViewModel
    val articleList = viewModel.articles.collectAsState().value
    val context = LocalContext.current

    // Show toast when error occurs
    LaunchedEffect(key1 = viewModel.showErorToastChannel) {
        viewModel.showErorToastChannel.collectLatest { show ->
            if (show) {
                Toast.makeText(context, "Failed to load articles", Toast.LENGTH_SHORT).show()
            }
        }
    }

    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxSize()
    ) {
        EdukasiTopBar()

        // Handle Loading and Display Articles
        if (articleList.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator() // Show loading spinner while waiting for data
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(15.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                // Section for Berita
                item {
                    Text(
                        text = "Berita",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    LazyRow(
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        items(berita, key = { it.id }) {
                            BeritaItem(berita = it) { beritaId ->
                                navController.navigate(Screen.detailberita.route + "/$beritaId")
                            }
                        }
                    }
                }

                // Section for Video
                item {
                    Text(
                        text = "Video",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    LazyRow(
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(video, key = { it.id }) {
                            VideoItem(video = it) { videoId ->
                                navController.navigate(Screen.detailvideo.route + "/$videoId")
                            }
                        }
                    }
                }
                item {
                    Text(
                        text = "Artikel",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                items(articleList, key = { it.id }) { article ->
                    ArtikelItem(artikel = article) { artikelId ->
                        navController.navigate(Screen.detailartikel.route + "/$artikelId")
                    }
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun EdukasiScreenPreview() {
//    val navController = rememberNavController()
//    EdukasiScreen(navController)
//}
