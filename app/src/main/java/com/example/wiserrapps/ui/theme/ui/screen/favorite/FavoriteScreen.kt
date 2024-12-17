//package com.example.wiserrapps.ui.theme.ui.screen.favorite
//
//import android.annotation.SuppressLint
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Tab
//import androidx.compose.material3.TabRow
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
//fun MateriFavoritScreen(navController: NavController) {
//    var selectedTabIndex by remember { mutableIntStateOf(0) }
//    val tabs = listOf("Video", "Berita", "Artikel")
//    Column(modifier = Modifier.fillMaxSize()) {
//        RoundedTopBar(title = "Materi Favorit", onBackClick = { navController.popBackStack() })
//        TabRow(
//            selectedTabIndex = selectedTabIndex,
//            containerColor = Color.White,
//            contentColor = Color(0xFF1976D2),
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            tabs.forEachIndexed { index, title ->
//                Tab(
//                    selected = selectedTabIndex == index,
//                    onClick = { selectedTabIndex = index },
//                    text = {
//                        Text(
//                            text = title,
//                            fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Normal,
//                            fontSize = 16.sp
//                        )
//                    }
//                )
//            }
//        }
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            contentAlignment = Alignment.Center
//        ) {
//            when (selectedTabIndex) {
//                0 -> VideoContent()
//                1 -> BeritaContent()
//                2 -> ArtikelContent()
//            }
//        }
//    }
//}
//
//
//@Composable
//fun RoundedTopBar(title: String, onBackClick: () -> Unit) {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(91.dp) // Tinggi TopBar
//            .background(
//                color = Color(0xFF1976D2),
//                shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
//            ),
//        contentAlignment = Alignment.Center
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp),
//            contentAlignment = Alignment.Center
//        ) {
//            IconButton(
//                onClick = onBackClick,
//                modifier = Modifier
//                    .align(Alignment.CenterStart)
//                    .size(32.dp) // Ukuran ikon
//            ) {
//                Icon(
//                    imageVector = Icons.Default.ArrowBack,
//                    contentDescription = "Kembali",
//                    modifier = Modifier.size(40.dp),
//                    tint = Color.White
//                )
//            }
//            Text(
//                text = title,
//                fontSize = 24.sp,
//                color = Color.White,
//                fontWeight = FontWeight.Bold,
//                textAlign = TextAlign.Center,
//                modifier = Modifier.align(Alignment.Center)
//            )
//        }
//    }
//}
//
//@Composable
//fun VideoContent() {
//    Text(text = "Konten Video", fontSize = 18.sp, fontWeight = FontWeight.Bold)
//}
//
//@Composable
//fun BeritaContent() {
//    Text(text = "Konten Berita", fontSize = 18.sp, fontWeight = FontWeight.Bold)
//}
//
//@Composable
//fun ArtikelContent() {
//    Text(text = "Konten Artikel", fontSize = 18.sp, fontWeight = FontWeight.Bold)
//}
