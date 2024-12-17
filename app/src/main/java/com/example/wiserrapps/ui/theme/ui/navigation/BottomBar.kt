package com.example.wiserrapps.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.wiserrapps.R
import com.example.wiserrapps.data.model.NavigationItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomBar(
    navController: NavHostController,
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val coroutineScope = rememberCoroutineScope()
    val isBottomSheetVisible = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NavigationBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(8.dp),
                    clip = false
                )
                .background(
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(8.dp)
                )
                .wrapContentSize(align = Alignment.Center),
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            val navigationItems = listOf(
                NavigationItem(
                    title = "Home",
                    icon = R.drawable.home,
                    screen = Screen.Home
                ),
                NavigationItem(
                    title = "Konsultasi",
                    icon = R.drawable.chat,
                    screen = Screen.Konsultasi
                ),
                NavigationItem(
                    title = "Tambah",
                    icon = R.drawable.tambah,
                    screen = Screen.HalalanPembuka
                ),
                NavigationItem(
                    title = "Edukasi",
                    icon = R.drawable.lgartikel,
                    screen = Screen.Edukasi
                ),
                NavigationItem(
                    title = "Komunitas",
                    icon = R.drawable.komunitas,
                    screen = Screen.Komunitas
                ),
            )

            navigationItems.forEach { item ->
                val iconSize = if (item.icon == R.drawable.tambah) 50.dp else 30.dp
                NavigationBarItem(
                    selected = currentRoute == item.screen.route,
                    onClick = {
                        if (item.title == "Tambah") {
                            coroutineScope.launch {
                                isBottomSheetVisible.value = true
                                sheetState.show()
                            }
                        } else {
                            navController.navigate(item.screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                restoreState = true
                                launchSingleTop = true
                            }
                        }
                    },
                    icon = {
                        Image(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title,
                            modifier = Modifier.size(iconSize)
                        )
                    }
                )
            }
        }
    }

    if (isBottomSheetVisible.value) {
        ModalBottomSheet(
            onDismissRequest = {
                coroutineScope.launch {
                    sheetState.hide()
                    isBottomSheetVisible.value = false
                }
            },
            sheetState = sheetState
        ) {
            BottomSheetContent(
                navController
            )
        }
    }
}

@Composable
fun BottomSheetContent(
    navController: NavController
) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(
                    topStart = 10.dp,
                    topEnd = 10.dp
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Laporan",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
            )
            Row(
                Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ReportItem(
                    icon = R.drawable.lapproduksi,
                    title = "Laporan Produksi",
                    onClick = { navController.navigate(Screen.inputlaporanproduksi.route) }
                )
                ReportItem(
                    icon = R.drawable.lapkeuangan,
                    title = "Laporan Keuangan",
                    onClick = {}
                )
                ReportItem(
                    icon = R.drawable.keuntungan,
                    title = "Keuntungan",
                    onClick = {}
                )
            }
        }
    }
}

@Composable
fun ReportItem(icon: Int, title: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color(0xFFA3D0EE))
                .clickable { onClick() }
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = title,
                modifier = Modifier.size(25.dp)
            )
        }
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReportItemPreview() {
    ReportItem(
        icon = R.drawable.lapproduksi,
        title = "Contoh Laporan",
        onClick = {}
    )
}
