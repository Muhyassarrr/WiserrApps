package com.example.wiserrapps.screen.masuk.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.wiserrapps.R

@Composable
fun Logo() {
    Image(
        painter = painterResource(id = R.drawable.logowiser2),
        contentDescription = "Logo",
        modifier = Modifier.size(135.dp).offset(y = 15.dp)
    )
}
