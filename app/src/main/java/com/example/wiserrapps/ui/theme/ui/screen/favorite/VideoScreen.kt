package com.example.wiserrapps.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wiserrapps.component.MateriItem
import androidx.navigation.NavHostController
import com.example.wiserrapps.data.Data.dummyMateriVideo


@Composable
fun VideoScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        dummyMateriVideo.forEach { materi ->
            MateriItem(
                title = materi.title,
                description = materi.description,
                imageRes = materi.imageRes,
                navController = navController,
                targetRoute = "videoDetailScreen/${materi.id}"
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
