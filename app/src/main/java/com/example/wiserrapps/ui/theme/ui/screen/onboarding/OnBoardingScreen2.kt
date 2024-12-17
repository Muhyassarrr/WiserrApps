package com.example.wiserrapps.ui.theme.ui.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wiserrapps.ui.theme.ui.screen.onboarding.component.CommonButton
import com.example.wiserrapps.ui.theme.ui.screen.onboarding.component.PagerIndicator
import com.example.wiserrapps.R
import com.example.wiserrapps.ui.navigation.Screen

@Composable
fun HalPembuka2(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.bg),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.img),
                contentDescription = "Gambar",
                modifier = Modifier
                    .requiredHeight(500.dp)
                    .requiredWidth(337.dp)
                    .size(300.dp)
                    .offset(y = (-50.dp))
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(20.dp)
                    .offset(y = -100.dp)
            ) {
                Text(
                    text = "Konsultasi Walet di Ujung Jari Anda",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color(0xFF2B3A67),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 1.dp)
                )
                Text(
                    text = "Tingkatkan hasil sarang walet Anda dengan pengetahuan dan manajemen yang tepat dari para ahli.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFF2B3A67),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                PagerIndicator(currentPage = 1, totalPages = 2)
            }
            CommonButton(
                text = "Selanjutnya",
                onClick = { navController.navigate(Screen.SignUp.route) },
                modifier = Modifier
                    .offset(y = -40.dp)
            )
        }
    }
}