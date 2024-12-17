//package com.example.newappwiserr.ui.screen.home.component
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.material3.Button
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.ModalBottomSheet
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.material3.rememberModalBottomSheetState
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import kotlinx.coroutines.launch
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun BottomSheet(
//){
//    val sheetState = rememberModalBottomSheetState(
//    skipPartiallyExpanded = true
//)
//    val coroutineScope = rememberCoroutineScope()
//
//    if (sheetState.isVisible)
//    ModalBottomSheet(
//        onDismissRequest = {
//            coroutineScope.launch {
//                sheetState.hide()
//            } },
//        sheetState = sheetState
//    ) {
//        Box(
//            Modifier.fillMaxWidth()
//                .height(300.dp)
//                .background(
//                    color = Color.White,
//                    shape = RoundedCornerShape(
//                        topStart = 10.dp,
//                        topEnd = 10.dp
//                    )
//                )
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(vertical = 20.dp),
//                verticalArrangement = Arrangement.SpaceBetween,
//                horizontalAlignment = Alignment.Start,
//            ) {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(start = 20.dp, end = 20.dp, top = 10.dp),
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text(
//                        text = "Pilih Bangunan",
//                        fontSize = 20.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                    Spacer(modifier = Modifier.width(50.dp))
//                    Text(
//                        text = "Hapus",
//                        style = TextStyle(
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight(400),
//                            color = Color(0xFF407CFF),
//                        ),
////                        modifier = Modifier.clickable {
////                            navController.navigate("loginpage")
////                        }
//                    )
//                    Text(
//                        text = "Tutup",
//                        style = TextStyle(
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight(400),
//                            color = Color(0xFF407CFF),
//                        ),
//                        modifier = Modifier
////                            .clickable {
////                            navController.navigate("loginpage")
////                        }
//                    )
//                }
//                OutlinedTextField(
//                    value = "",
//                    onValueChange = {},
//                    placeholder = { Text("Belum memiliki bangunan") },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 16.dp,) ,
//                            leadingIcon = {
//                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
//                    }
//                )
//                Spacer(modifier = Modifier.height(10.dp))
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                    ) {
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(51.dp)
//                                .padding(horizontal = 25.dp)
//                                .shadow(
//                                    elevation = 4.dp,
//                                    shape = RoundedCornerShape(8.dp),
//                                    clip = false
//                                )
//                                .background(
//                                    Color(0xFFA3D0EE),
//                                    RoundedCornerShape(7.dp)
//                                ),
//                            contentAlignment = Alignment.Center
//                        ){
//                            Text(
//                                text = "Buat Bangunan"
//                            )
//                        }
//                    }
//                }
//            }
//        }
////    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun BottomSheetPreview() {
//    BottomSheet(
//    )
//}
