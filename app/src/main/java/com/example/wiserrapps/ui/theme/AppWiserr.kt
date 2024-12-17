package com.example.wiserrapps

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.wiserrapps.ui.screen.edukasi.component.DetailVideoScreen
import com.example.wiserrapps.data.model.Profiles
import com.example.wiserrapps.ui.navigation.CustomBottomBar
import com.example.wiserrapps.ui.navigation.Screen
import com.example.wiserrapps.ui.screen.HalamanPembuka
import com.example.wiserrapps.ui.screen.edukasi.EdukasiScreen
import com.example.wiserrapps.ui.screen.edukasi.component.DetailArtikelScreen
import com.example.wiserrapps.ui.screen.edukasi.component.DetailBeritaScreen
import com.example.wiserrapps.ui.screen.harga.HargaScreen
import com.example.wiserrapps.ui.screen.splash.SplashScreen
import com.example.wiserrapps.ui.screen.home.HomeScreen
import com.example.wiserrapps.ui.screen.komunitas.KomunitasScreen
import com.example.wiserrapps.ui.screen.konusltasi.KonsultasiScreen
import com.example.wiserrapps.ui.screen.laporan.LaporanProduksi
import com.example.wiserrapps.ui.screen.masuk.LogInScreen
import com.example.wiserrapps.ui.screen.masuk.SignUpScreen
import com.example.wiserrapps.ui.screen.profile.ProfileScreen
import com.example.wiserrapps.ui.theme.ui.screen.onboarding.HalPembuka
import com.example.wiserrapps.ui.theme.ui.screen.onboarding.HalPembuka2
import com.example.wiserrapps.ui.theme.ui.screen.pengaturan.DeleteAccountScreenContent
import com.example.wiserrapps.ui.theme.ui.screen.pengaturan.PengaturanPage
import com.example.wiserrapps.ui.theme.ui.screen.pengaturan.UbahKataSandiPage
import com.example.wiserrapps.ui.theme.ui.screen.profile.UbahProfil
import com.example.wiserrapps.utils.shouldShowBottomBar
import com.example.wiserrapps.utils.shouldShowFloatingActionBar
import com.example.wiserrapps.Screen.MainScreen
import com.example.wiserrapps.ui.theme.ui.screen.chatbot.Chatbot
import com.example.wiserrapps.ui.theme.ui.screen.laporan.LaporanMainScreen

@Composable
fun AppWiserr(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val context = LocalContext.current

    Scaffold(
        bottomBar = {
            AnimatedVisibility(visible = currentRoute.shouldShowBottomBar()) {
                CustomBottomBar(
                    navHostController
                )
            }
        },
        floatingActionButton = {
            AnimatedVisibility(visible = currentRoute.shouldShowFloatingActionBar()) {
                FloatingActionButton(
                    onClick = {
                        navHostController.navigate(Screen.chatbot.route)
                    },
                    containerColor = (Color.White),
                    shape = CircleShape,
                    modifier = Modifier.size(60.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lgwalet),
                        contentDescription = "Icon Chat",
                        modifier = Modifier
                            .size(45.dp)
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navHostController,
            startDestination = Screen.Splash.route,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(Screen.Splash.route) {
                SplashScreen(navController = navHostController)
            }
            composable(Screen.SignUp.route) {
                SignUpScreen(navController = navHostController)
            }
            composable(Screen.LogIn.route) {
                LogInScreen(navController = navHostController)
            }
            val profiles = Profiles(1,"Brian","Brian",R.drawable.ftbrian1)
            composable(Screen.Home.route) {
                HomeScreen(profiles = profiles, navController = navHostController)
            }
            composable(Screen.HalalanPembuka.route) {
                HalamanPembuka()
            }
            composable(Screen.LaporanProduksi.route) {
                LaporanProduksi(navController = navHostController)
            }

            composable(Screen.Edukasi.route) {
                EdukasiScreen(navController = navHostController)
            }
            composable(Screen.ListHarga.route) {
                HargaScreen(navController = navHostController)
            }
            composable(Screen.Komunitas.route) {
                KomunitasScreen()
            }
            composable(Screen.Konsultasi.route) {
                KonsultasiScreen(profiles = profiles,navController = navHostController)
            }
            composable(Screen.Profile.route) {
                ProfileScreen(navController = navHostController)
            }
            composable(Screen.OnBoarding.route) {
                HalPembuka(navController = navHostController)
            }
            composable(Screen.OnBoarding2.route) {
                HalPembuka2(navController = navHostController)
            }
            composable(Screen.ubahProfile.route) {
                UbahProfil(navController = navHostController)
            }
            composable(Screen.favorite.route) {
                MainScreen(navController = navHostController)
            }
            composable(
                Screen.detailberita.route + "/{beritaId}",
                arguments = listOf(navArgument("beritaId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailBeritaScreen(
                    navController = navHostController,
                    beritaId = navBackStackEntry.arguments?.getInt("beritaId")
                )
            }
            composable(
                Screen.detailvideo.route + "/{videoId}",
                arguments = listOf(navArgument("videoId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailVideoScreen(
                    navController = navHostController,
                    videoId = navBackStackEntry.arguments?.getInt("videoId"),
                )
            }
            composable(
                Screen.detailartikel.route + "/{artikelId}",
                arguments = listOf(navArgument("artikelId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailArtikelScreen(
                    navController = navHostController,
                    artikelId = navBackStackEntry.arguments?.getInt("artikelId"),
                )
            }
            composable(Screen.pengaturan.route) {
                PengaturanPage(navController = navHostController)
            }
            composable(Screen.ubahsandi.route) {
                UbahKataSandiPage(navController = navHostController)
            }
            composable(Screen.inputlaporanproduksi.route) {
                LaporanMainScreen(navController = navHostController)
            }
            composable(Screen.chatbot.route) {
                Chatbot(navController = navHostController)
            }
        }
    }
}