package com.example.wiserrapps.ui.theme.ui.screen.pengaturan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ResetPasswordScreenContent() {
    Scaffold(
        topBar = {
            Surface(
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0x40000000),
                        ambientColor = Color(0x40000000)
                    )
                    .height(91.dp)
                    .fillMaxWidth()
                    .shadow(4.dp),
                color = Color(0xFF246AA4),
                shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Ikon kembali di sebelah kiri
                    IconButton(
                        onClick = { /* Navigasi kembali */ },
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 16.dp) // Menambahkan padding kiri
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            modifier = Modifier.size(40.dp),
                            tint = Color.White
                        )
                    }

                    // Teks di tengah
                    Text(
                        text = "Reset Sandi",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Title Text
            Text(
                text = "Lupa kata sandi ?",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Description Text
            Text(
                text = "Masukkan alamat email anda, kami akan mengirimkan link reset kata sandi.",
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(16.dp))


            Text(
                text = "Email",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Email Input Field
            OutlinedTextField(
                value = "", // Initial value
                onValueChange = { /* Handle text input */ },
                label = { Text("Alamat email") },
                placeholder = { Text("Alamat email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                textStyle = TextStyle(fontSize = 14.sp),
                shape = RoundedCornerShape(8.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Button for sending reset link
            Button(
                onClick = { /* Handle button click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                enabled = false, // Initially disabled
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE0E0E0), // Light gray color
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Kirim link reset kata sandi",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Link to use phone number
            Text(
                text = "Gunakan nomor HP",
                fontSize = 18.sp,
                color = Color(0xFF2A85D2), // Blue color
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable { /* Handle navigation to phone reset */ }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewResetPasswordScreenContent() {
    ResetPasswordScreenContent()
}