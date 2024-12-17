package com.example.wiserrapps.ui.theme.ui.screen.komunitas

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WaletCommunityScreenContent(
    onBackClick: () -> Unit,
    navController: NavController
) {
    // State untuk tab yang dipilih
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Postingan", "Media", "Obrolan")

    // Scaffold dengan TopBar
    Scaffold(
        topBar = {
            CoverSection(onBackClick = onBackClick) // Pastikan CoverSection terdefinisi
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(12.dp)
        ) {
            ProfileSection() // Pastikan ProfileSection terdefinisi
            ActionButtons() // Pastikan ActionButtons terdefinisi

            // TabRow dengan penggantian parameter backgroundColor menjadi containerColor
            TabRow(
                selectedTabIndex = selectedTab,
                containerColor = Color.White // Warna background TabRow
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = {
                            Text(
                                text = title,
                                fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Normal,
                                color = if (selectedTab == index) Color(0xFF246AA4) else Color.Gray
                            )
                        }
                    )
                }
            }

            // Konten sesuai tab yang dipilih
            when (selectedTab) {
                0 -> PostinganTab() // Pastikan PostinganTab terdefinisi
                1 -> MediaTab()     // Pastikan MediaTab terdefinisi
                2 -> ObrolanTab()   // Pastikan ObrolanTab terdefinisi
            }
        }
    }
}



@Composable
fun CoverSection(
    onBackClick: () -> Unit,
//    onClick: ()-> Unit
) {
    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val photoPickerLaucher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            selectedImageUri = it
        }
    )

    Column {
        // Bagian atas dengan background abu-abu
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(Color.LightGray), // Background abu-abu
            contentAlignment = Alignment.TopStart
        ) {
            // Tombol kembali
            IconButton(
                onClick = onBackClick,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.size(40.dp),
                    tint = Color.White
                )
            }

            // Teks "Tambah Foto"
            Text(
                text = "Tambah Foto",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )

            // Foto profil
            Box(
                modifier = Modifier
                    .absoluteOffset(x = 30.dp, y = 120.dp)
                    .size(87.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF246AA4))
                    .clickable { photoPickerLaucher.launch(
                        PickVisualMediaRequest( ActivityResultContracts.PickVisualMedia.ImageOnly)
                    ) }

            ) {
                AsyncImage(
                    modifier = Modifier
                        .absoluteOffset(x = 30.dp, y = 120.dp)
                        .size(87.dp)
                        .clip(CircleShape),
                    model = selectedImageUri ,
                    contentDescription = null
                )
                Icon(
                    imageVector = Icons.Default.PhotoCamera,
                    contentDescription = "Edit Profile",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center),
                )
            }
        }


        // Bagian bawah (ikon lokasi dan notifikasi di atas background putih)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp ), // Jarak di area putih
            horizontalArrangement = Arrangement.End, // Posisi ikon ke arah kanan
            verticalAlignment = Alignment.CenterVertically // Menyejajarkan secara vertikal
        ) {
            // Lokasi
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location",
                    tint = Color.Black, // Warna hitam
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Indonesia",
                    fontSize = 14.sp,
                    color = Color.Black // Warna teks hitam
                )
            }

            Spacer(modifier = Modifier.width(12.dp)) // Jarak antara lokasi dan notifikasi

            // Notifikasi
            IconButton(
                onClick = { /* Handle notification click */ }
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications",
                    tint = Color.Black, // Warna hitam
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}



@Composable
fun ProfileSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Pengusaha Sarang Walet",
            fontSize = 24.sp,
            lineHeight = 36.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Komunitas pengusaha sarang walet seluruh daerah di Indonesia.",
            fontSize = 15.sp,
            lineHeight = 22.5.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun ActionButtons() {
    // State untuk tombol Gabung
    var isJoined by remember { mutableStateOf(false) }
    // State untuk tombol Undang
    var isInvited by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Tombol Gabung
        Button(
            onClick = {
                isJoined = !isJoined // Toggle status ketika tombol ditekan
            },
            modifier = Modifier
                .width(123.dp)
                .height(31.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isJoined) Color.Gray else Color(0xFF246AA4) // Ubah warna tombol
            ),
            shape = RoundedCornerShape(size = 12.dp)
        ) {
            Text(
                text = if (isJoined) "Bergabung" else "Gabung", // Ubah teks berdasarkan status
                color = Color.White
            )
        }

        // Tombol Undang
        Button(
            onClick = {
                isInvited = !isInvited // Toggle status ketika tombol ditekan
            },
            modifier = Modifier
                .width(123.dp)
                .height(31.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isInvited) Color.Gray else Color(0xFF246AA4) // Ubah warna tombol
            ),
            shape = RoundedCornerShape(size = 12.dp)
        ) {
            Text(
                text = "Undang",
                color = Color.White
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostinganTab() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 8.dp) // Tambah padding bawah agar ada jarak
    ) {
        // Bagian informasi "Belum ada postingan."
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Belum ada postingan.",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        // Input teks dengan gambar profil dan ikon kamera di bagian bawah
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter) // Letakkan di bawah layar
                .background(Color(0xFFE7F3FF))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Foto profil
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF246AA4)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.PhotoCamera,
                    contentDescription = "Edit Profile",
                    tint = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // TextField untuk posting
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.weight(1f),
                placeholder = { Text("Posting...") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Ikon kamera
            IconButton(
                onClick = { /* Handle camera click */ }
            ) {
                Icon(
                    imageVector = Icons.Default.PhotoCamera,
                    contentDescription = "Camera",
                    tint = Color(0xFF246AA4)
                )
            }
        }
    }
}

@Composable
fun MediaTab() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(6) {
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .aspectRatio(1f)
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Media", color = Color.White)
            }
        }
    }
}

@Composable
fun ObrolanTab() {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(5) {
                Text("Pesan $it", modifier = Modifier.padding(8.dp))
            }
        }
        Row(modifier = Modifier.padding(16.dp)) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.weight(1f),
                placeholder = { Text("Tulis sesuatu...") }
            )
            Button(onClick = {}) {
                Text("Kirim")
            }
        }
    }
}
