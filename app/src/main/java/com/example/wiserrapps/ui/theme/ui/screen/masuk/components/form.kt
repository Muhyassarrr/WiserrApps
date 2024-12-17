package com.example.wiserrapps.screen.masuk.components

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.wiserrapps.R
import com.example.wiserrapps.ui.navigation.Screen
import com.example.wiserrapps.ui.theme.ui.screen.masuk.LoginViewModel
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import com.google.android.gms.auth.api.signin.GoogleSignIn
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import kotlinx.coroutines.launch

@Composable
fun SignUpForm(navController: NavController) {
    AuthForm(
        title = "Daftar Sekarang!",
        subtitle = "Halo,",
        buttonText = "Daftar",
        navController = navController,
        onFormSubmit = { navController.navigate(Screen.LogIn.route) },
        footerText = "Sudah punya akun? Masuk",
        onFooterClick = { navController.navigate(Screen.LogIn.route) }
    )
}

@Composable
fun LogInForm(navController: NavController) {
    AuthForm(
        title = "Selamat Datang Kembali!",
        subtitle = "Halo,",
        buttonText = "Masuk",
        navController = navController,
        onFormSubmit = { navController.navigate(Screen.Home.route) },
        footerText = "Belum punya akun? Daftar",
        onFooterClick = { navController.navigate(Screen.SignUp.route) }
    )
}

@Composable
fun AuthForm(
    title: String,
    subtitle: String,
    buttonText: String,
    navController: NavController,
    onFormSubmit: () -> Unit,
    footerText: String,
    onFooterClick: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val state = viewModel.state.collectAsState(initial = null)
    val googleLoginState = viewModel.stateGoogle.value


    @Suppress("DEPRECATION")
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {
            val account = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            try {
                val result = account.getResult(ApiException::class.java)
                val credential = GoogleAuthProvider.getCredential(result.idToken, null)
                viewModel.loginWithGoogle(credential) {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.LogIn.route) {
                            inclusive = true
                        }
                    }
                }
            } catch (it: ApiException) {
                Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
            }
        }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .width(350.dp)
                .background(Color.White, shape = RoundedCornerShape(40.dp))
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = subtitle,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF17466E)
            )
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF17466E)
            )
            if (title == "Daftar Sekarang!") {
                CustomTextField(
                    value = fullName,
                    onValueChange = { fullName = it },
                    label = "Nama lengkap"
                )
            }
            CustomTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email"
            )
            CustomPasswordField(
                value = password,
                onValueChange = { password = it },
                label = "Kata sandi",
                passwordVisible = passwordVisible,
                onVisibilityChange = { passwordVisible = !passwordVisible }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    coroutineScope.launch {
                        if (email.isBlank() || password.isBlank()) {
                            Toast.makeText(
                                context,
                                "Email dan Password Wajib Diisi",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        } else {
                            viewModel.registerUser(email, password) {
                                navController.navigate(Screen.LogIn.route) {
                                    popUpTo(Screen.SignUp.route) { inclusive = true }
                                }
                                email = ""
                                password = ""
                            }
                        }
                    }
                    coroutineScope.launch {
                        if (email.isBlank() || password.isBlank()) {
                            Toast.makeText(
                                context,
                                "Email dan Password Wajib Diisi",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        } else {
                            viewModel.loginUser(email, password) {
                                navController.navigate(Screen.Home.route) {
                                    popUpTo(Screen.LogIn.route) {
                                        inclusive = true
                                    }
                                }
                                email = ""
                                password = ""
                            }
                        }
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF246AA4)),
            ) {
                Text(text = buttonText, color = Color.White, fontSize = 18.sp)
            }

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Atau", color = Color.Gray, fontSize = 14.sp)
            }

            SocialLoginButtons()

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = footerText,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .clickable { onFooterClick() }
                )
            }
        }
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        shape = RoundedCornerShape(7.dp)
    )
}

@Composable
fun CustomPasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    passwordVisible: Boolean,
    onVisibilityChange: () -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        shape = RoundedCornerShape(7.dp),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val icon = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            IconButton(onClick = onVisibilityChange) {
                Icon(imageVector = icon, contentDescription = "Toggle Password Visibility")
            }
        }
    )
}

@Composable
fun SocialLoginButtons() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = {}) {
            Icon(
                painter = painterResource(id = R.drawable.glg),
                contentDescription = "Google",
                tint = Color.Unspecified,
                modifier = Modifier.size(48.dp)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))

        IconButton(onClick = { /* Handle Facebook sign in */ }) {
            Icon(
                painter = painterResource(id = R.drawable.lgfb),
                contentDescription = "Facebook",
                tint = Color.Unspecified,
                modifier = Modifier.size(48.dp)
            )
        }
    }
}
