package com.example.wiserrapps.ui.theme.ui.screen.pengaturan

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UbahKataSandiPage(navController: NavHostController) {
    Scaffold(
        topBar = {
            Surface(
                modifier = Modifier
                    .shadow(elevation = 4.dp, spotColor = Color(0x40000000), ambientColor = Color(0x40000000))
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
                        text = "Ubah Sandi",
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
                .padding(16.dp)
        )
        {
            Text(
                text = "Kata Sandi Saat Ini",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))


            PasswordField(
                label = "Kata sandi saat ini",
                placeholder = "Kata sandi saat ini",
                isRequired = true
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Kata Sandi Baru",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))

            PasswordField(
                label = "Kata sandi baru",
                placeholder = "Kata sandi baru",
                isRequired = true
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Ulang Kata Sandi Baru",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))

            PasswordField(
                label = "Ulang kata sandi baru",
                placeholder = "Ulang kata sandi baru",
                isRequired = true
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Lupa kata sandi?",
                color = Color(0xFF007BFF),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.align(Alignment.End).clickable { /* Logika lupa kata sandi */ }
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { /* Logika untuk menyimpan perubahan */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF246AA4))
            ) {
                Text(text = "Simpan", color = Color.White)
            }
        }
    }
}

@Composable
fun PasswordField(
    label: String,
    placeholder: String,
    isRequired: Boolean
) {
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = {
            Row {
                Text(text = label)
                if (isRequired) {
                    Text(text = "*", color = Color.Red)
                }
            }
        },
        placeholder = { Text(text = placeholder) },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Lock, contentDescription = null)
        },
        trailingIcon = {
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(
                    imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = null
                )
            }
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewUbahKataSandiPage() {
    val navController = rememberNavController()
    UbahKataSandiPage(navController = navController)
}