package com.example.wiserrapps.ui.navigation

sealed class Screen(val route: String) {
    data object SignUp: Screen("daftar")
    data object LogIn: Screen("masuk")
    data object Home: Screen("home")
    data object HalalanPembuka: Screen("halamanpembuka1")
    data object Splash: Screen("splash")
    data object LaporanProduksi: Screen("lapproduksi")
    data object Edukasi: Screen("edukasi")
    data object ListHarga: Screen("listharga")
    data object Komunitas: Screen("komunitas")
    data object Konsultasi: Screen("konsultasi")
    data object Profile: Screen("profil")
    data object OnBoarding: Screen("onboarding")
    data object OnBoarding2: Screen("onboarding2")
    data object ubahProfile: Screen("ubahprofile")
    data object favorite: Screen("favorite")
    data object detailberita: Screen("detailberita")
    data object detailvideo: Screen("detaivideo")
    data object detailartikel: Screen("detaiartikel")
    data object pengaturan: Screen("pengaturan")
    data object ubahsandi: Screen("ubahsandi")
    data object hapusakun: Screen("hapusakun")
    data object Video : Screen("video")
    data object Berita : Screen("berita")
    data object Artikel : Screen("artikel")
    data object Main : Screen("main")
    data object videoyt : Screen("videoyt")
    data object inputlaporanproduksi : Screen("produksi")
    data object datakomunitas : Screen("datakomunitas")
    data object chatbot : Screen("chatbot")

}