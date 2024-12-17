package com.example.wiserrapps.ui.theme.ui.screen.onboarding


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wiserrapps.ui.theme.ui.screen.onboarding.component.CommonButton
import com.example.wiserrapps.ui.theme.ui.screen.onboarding.component.PagerIndicator
import com.example.wiserrapps.R
import com.example.wiserrapps.ui.navigation.Screen

@Composable
fun HalPembuka(
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
                painter = painterResource(R.drawable.image2),
                contentDescription = "Image2",
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
                    text = "Raih Kesuksesan di Bisnis Sarang Walet",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color(0xFF2B3A67),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 1.dp)
                )
                Text(
                    text = "Bangun bisnis sarang burung walet dengan fondasi yang kuat.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFF2B3A67),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                PagerIndicator(currentPage = 0, totalPages = 2)
            }
            CommonButton(
                text = "Selanjutnya",
                onClick = { navController.navigate(Screen.OnBoarding2.route) },
                modifier = Modifier
                    .offset(y = -40.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HalPembukaPreview() {
    val navController = rememberNavController()
    HalPembuka(navController)
}


