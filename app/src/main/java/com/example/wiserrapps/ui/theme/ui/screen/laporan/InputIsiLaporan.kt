package com.example.wiserrapps.ui.theme.ui.screen.laporan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun LaporanMainScreen(
    navController: NavController
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Produksi", "Target")

    Scaffold(
        topBar = {
            Surface(
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0x40000000),
                        ambientColor = Color(0x40000000)
                    )
                    .height(91.dp)
                    .fillMaxWidth(),
                color = Color(0xFF246AA4),
                shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize()
                    ,
                    contentAlignment = Alignment.Center,


                    ) {
                    // Rounded Button Tab Navigation
                    Row(
                        modifier = Modifier
                            .background(
                                color = Color(0xFF246AA4),
                                shape = RoundedCornerShape(50)
                            ).padding(start = 16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        tabs.forEachIndexed { index, title ->
                            Button(
                                onClick = { selectedTab = index },
                                modifier = Modifier
                                    .size(width = 120.dp, height = 33.94274.dp)
                                    .padding(horizontal = 4.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (selectedTab == index) Color.White else Color(0xFF246AA4),
                                    contentColor = if (selectedTab == index) Color(0xFF246AA4) else Color.White
                                ),
                                shape = CircleShape,
//                                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
                            ) {
                                Text(
                                    text = title,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }

                    // Back Button positioned at top-left
                    IconButton(
                        onClick = { /* Handle Back */ },
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            modifier = Modifier.size(40.dp),
                            tint = Color.White,

                            )
                    }
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            // Show the appropriate page
            when (selectedTab) {
                0 -> InputProduksiPage()
                1 -> InputTargetPage()
            }
        }
    }
}



@Composable
fun InputProduksiPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        DropdownField(label = "Bangunan*", hint = "#01 - Brian Domani - Luwu")
        Spacer(modifier = Modifier.height(8.dp))
        DropdownField(label = "Sarang Walet*", hint = "Pilih bentuk")
        Spacer(modifier = Modifier.height(8.dp))
        DropdownField(label = "Tahap*", hint = "Pilih panen/produksi")
        Spacer(modifier = Modifier.height(8.dp))
        DropdownField(label = "Tanggal*", hint = "Pilih tanggal", isDate = true) // Menambahkan kalender
        Spacer(modifier = Modifier.height(8.dp))
        InputField(label = "Jumlah (kg)*", hint = "Isi jumlah sarang", isLong = false)
        Spacer(modifier = Modifier.height(8.dp))
        InputField(label = "Catatan (Opsional)", hint = "Catatan", isLong = true)
    }
}


@Composable
fun InputTargetPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        DropdownField(label = "Bulan*", hint = "Pilih bulan")
        Spacer(modifier = Modifier.height(8.dp))
        InputField(label = "Jumlah (kg)*", hint = "Isi jumlah sarang", isLong = false) // Tetap ukuran standar
        Spacer(modifier = Modifier.height(8.dp))
        InputField(label = "Catatan (Opsional)", hint = "Catatan", isLong = true) // Lebih panjang untuk catatan
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownField(label: String, hint: String, isDate: Boolean = false) {
    Column {
        Text(text = label, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Box {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(hint, color = Color(0xFF609AC1)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF246AA4),
                    unfocusedBorderColor = Color(0xFF609AC1)
                ),
                trailingIcon = {
                    if (isDate) {
                        Icon(
                            imageVector = Icons.Default.CalendarToday,
                            contentDescription = "Calendar Icon",
                            tint = Color(0xFF609AC1)
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Dropdown Arrow",
                            tint = Color(0xFF609AC1)
                        )
                    }
                }
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(label: String, hint: String, isLong: Boolean) {
    var text by remember { mutableStateOf("") }  // Menambahkan state untuk input

    Column {
        Text(text = label, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = text,  // Menyimpan nilai input
            onValueChange = { text = it },  // Mengupdate nilai input saat berubah
            placeholder = { Text(hint, color = Color(0xFF609AC1)) },
            modifier = Modifier
                .fillMaxWidth()
                .height(if (isLong) 120.dp else 56.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF246AA4),
                unfocusedBorderColor = Color.Gray
            ),
            maxLines = if (isLong) 5 else 1,
            textStyle = LocalTextStyle.current.copy(lineHeight = if (isLong) 20.sp else 16.sp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
//    LaporanMainScreen()
}