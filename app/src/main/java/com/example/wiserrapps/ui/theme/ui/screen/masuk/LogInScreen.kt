package com.example.wiserrapps.ui.screen.masuk

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wiserrapps.screen.masuk.components.LogInForm
import com.example.wiserrapps.screen.masuk.components.Logo

@Composable
fun LogInScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA3D0EE)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Logo()
//        Spacer(modifier = Modifier.height(45.dp))

        LogInForm(navController)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLogInScreen() {
    val navController = rememberNavController()
    LogInScreen(navController = navController)
}