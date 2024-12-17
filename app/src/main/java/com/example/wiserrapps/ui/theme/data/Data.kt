package com.example.wiserrapps.data

import androidx.compose.ui.graphics.Color
import com.example.newappwiser.model.MateriArtikel
import com.example.newappwiser.model.MateriBerita
import com.example.newappwiser.model.MateriVideo
import com.example.wiserrapps.R
import com.example.wiserrapps.data.model.Card
import com.example.wiserrapps.data.model.komunitas
import com.example.wiserrappsr.data.model.DataProduksi

object Data {

    val items = listOf(
        Card(
            "Mangkok", Color(0xFF266EA6)
        ),
        Card(
            "Sudut", Color(0xFF2E85C8)
        ),
        Card(
            "Oval", Color(0xFF4D9EDB)
        ),
        Card(
            "Patahan", Color(0xFF7CB5E1)
        )
    )
    val dataProduksi = listOf(
        DataProduksi("Mangkok", 0f),
        DataProduksi("Oval", 0f),
        DataProduksi("Sudut", 0f),
        DataProduksi("Patahan", 0f)
    )
    val Komunitas = listOf(
        komunitas("Peternak walet Surabaya", "315 anggota", R.drawable.k3),
        komunitas("Jual/beli sarang walet", "520 anggota", R.drawable.k4),
        komunitas("Komunitas Walet Jakarta", "450 anggota", R.drawable.k3),
        komunitas("Forum Walet Indonesia", "680 anggota", R.drawable.k4),
        komunitas("Supplier Pakan Walet", "290 anggota", R.drawable.k3),
    )
    val dummyMateriVideo = listOf(
        MateriVideo(1, "Pengenalan Budidaya Walet", "Deskripsi materi", R.drawable.video1),
        MateriVideo(2, "Konstruksi Gedung Walet", "Deskripsi materi", R.drawable.video2)
    )

    val dummyMateriBerita = listOf(
        MateriBerita(1, "Barantin Akan Tingkatkan Devis Lewat Ekspor Sarang Burung Walet ke China", "Badan Karantina Indonesia (Barantin) berkomitmen mendukung....", R.drawable.berita1),
        MateriBerita(2, "Sarang Burung Walet dalam Pengobatan Tradisional Tiongkok...", "Sarang burung walet telah lama dikenal sebagai...", R.drawable.berita2),
        MateriBerita(3, "Peluang dan Tantangan Peternak Burung di...", "Peternakan burung walet kini mulai merambah daerah perkotaan didorong oleh...", R.drawable.berita3)
    )

    val dummyMateriArtikel = listOf(
        MateriArtikel(1, "Menuju Sukses dengan BUdidaya Sarang Burung Walet", "Di tengah tingginya nilai ekspor kebeutuhan sarang burung walet di tingkat global...", R.drawable.artikel1),
        MateriArtikel(2, "Kandungan Nirit pada Sarang Burung Walaet dan Dampaknya...", "Sarang burung walet dihasilkan oleh empat spesies utama melalui air liur yang...", R.drawable.artikel2)

    )

}