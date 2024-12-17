package com.example.wiserrapps.ui.screen.konusltasi.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wiserrapps.R
import com.example.wiserrapps.data.model.Profiles

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KonsultasiTopBar(
profiles: Profiles
) {
    var text by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(190.dp)
            .background(
                color = Color(0xFF609AC1),
                shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .width(280.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = profiles.photo),
                        contentDescription = "Profile Image",
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            ) {
                                append("Hai, " + profiles.nickname)
                            }
                            append("\nButuh Konsultasi sekarang?")
                        },
                        fontSize = 15.sp,
//                        textAlign = TextAlign.Justify,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 10.dp),
                        style = TextStyle(
                            lineHeight = 15.sp
                        )
                    )
                }
                // Gambar Icon
                Image(
                    painter = painterResource(id = R.drawable.fav),
                    contentDescription = "Icon Artikel",
                    modifier = Modifier
                        .size(30.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(68.dp)
                    .padding(top = 10.dp)
                    .padding(horizontal = 20.dp)
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(8.dp),
                        clip = false
                    )
                    .background(
                        color = Color(0xFFD6E1EE),
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                TextField(
                    value = text,
                    onValueChange = { newText -> text = newText },
                    placeholder = {
                        Text(
                            text = "Tulis disini......",
                            color = Color(0xFF17466E),
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterStart) // Pastikan placeholder sejajar di awal
                        )
                    },
                    trailingIcon = { // Menggunakan trailingIcon untuk ikon di kanan
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .padding(8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Send,
                                contentDescription = "Send Icon",
                                tint = Color(0xFF17466E), // Warna ikon
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KonsultasiTopBar(){
    KonsultasiTopBar(
        profiles = Profiles(
            id = 1,
            nama = "Brian Domani",
            nickname = "Brian",
            photo = R.drawable.ftbrian1
        )
    )
}