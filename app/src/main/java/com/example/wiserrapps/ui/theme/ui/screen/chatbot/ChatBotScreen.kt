package com.example.wiserrapps.ui.theme.ui.screen.chatbot

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wiserrapps.R

@Composable
fun Chatbot(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(91.dp)
                .background(
                    Color(0xFF609AC1),
                    (RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.lgwalet),
                contentDescription = "Icon Chat",
                modifier = Modifier
                    .size(54.dp)
            )
        }

        IconButton(
            onClick =  { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                modifier = Modifier.size(30.dp),
                contentDescription = "Back",
                tint = Color.White
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.BottomCenter)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(8.dp),
                        clip = false
                    )
                    .background(
                        color = Color(0xFFD6E1EE), // Warna putih untuk background
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center // Posisi konten di bagian bawah tengah
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Tulis disini...... ",
                        color = (Color (0xFF17466E))
                    )
                    Icon(
                        imageVector = Icons.Filled.Send,
                        contentDescription = "Send Icon",
                        tint = Color(0xFF17466E), // Warna ikon
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatbotPreview() {
    val navController = rememberNavController()
    Chatbot (navController = navController)
}