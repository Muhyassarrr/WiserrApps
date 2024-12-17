package com.example.wiserrapps.ui.screen.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wiserrapps.R
import com.example.wiserrapps.ui.navigation.Screen
import com.example.wiserrapps.ui.screen.profile.MenuItem

@Composable
fun CardWhite(navController: NavController){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.White,
                    shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Akun",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(vertical = 8.dp)

                )
                Column(
                    modifier = Modifier
                        .clickable { navController.navigate(Screen.favorite.route) }
                ) {
                    MenuItem(
                        iconId = R.drawable.fav,
                        text = "Materi Favorit",
                        modifier = Modifier
                    )
                    HorizontalDivider(
                        color = Color.LightGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .clickable { }
                ) {
                    MenuItem(
                        iconId = R.drawable.fav,
                        text = "Riwayat Transaksi",
                        modifier = Modifier
                    )
                    HorizontalDivider(
                        color = Color.LightGray,
                        thickness = 1.dp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                Text(
                    text = "Bantuan",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Column(
                    modifier = Modifier
                        .clickable { navController.navigate(Screen.favorite.route) }
                ) {
                    MenuItem(
                        iconId = R.drawable.fav,
                        text = "Pusat Bantuan",
                        modifier = Modifier
                    )
                    HorizontalDivider(
                        color = Color.LightGray,
                        thickness = 1.dp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                Text(
                    text = "Keamanan & Lainnya",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Column(
                    modifier = Modifier
                        .clickable { navController.navigate(Screen.pengaturan.route)}
                ) {
                    MenuItem(
                        iconId = R.drawable.fav,
                        text = "Pengaturan",
                        modifier = Modifier
                    )
                    HorizontalDivider(
                        color = Color.LightGray,
                        thickness = 1.dp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .clickable {}
                ) {
                    MenuItem(
                        iconId = R.drawable.fav,
                        text = "Kebijakan Privasi",
                        modifier = Modifier
                    )
                    HorizontalDivider(
                        color = Color.LightGray,
                        thickness = 1.dp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .clickable { }
                ) {
                    MenuItem(
                        iconId = R.drawable.rate4star,
                        text = "Beri Rating",
                        modifier = Modifier
                    )
                    HorizontalDivider(
                        color = Color.LightGray,
                        thickness = 1.dp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))

                Button(
                    onClick = { navController.navigate(Screen.LogIn.route) },
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .fillMaxWidth()
                        .height(55.dp),
                    colors = ButtonDefaults
                        .buttonColors(containerColor = Color(0xFF1976D2)
                    )
                ) {
                    Text(text = "Keluar", fontSize = 18.sp, color = Color.White)
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun CardwhitePreview(){
    val navController = rememberNavController()
    CardWhite(navController)
}
