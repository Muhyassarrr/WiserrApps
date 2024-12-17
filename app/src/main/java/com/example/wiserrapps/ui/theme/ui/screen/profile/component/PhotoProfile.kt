package com.example.wiserrapps.ui.theme.ui.screen.profile.component

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
@Composable
fun PhotoProfile(
    modifier: Modifier = Modifier
) {
    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            selectedImageUri = it
        }
    )

    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(Color.White)
            .clickable {
                photoPickerLauncher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
            },
        contentAlignment = Alignment.Center
    ) {
        if (selectedImageUri != null) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize() // Mengisi ukuran penuh Box
                    .clip(CircleShape),
                model = selectedImageUri,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        } else {
            Icon(
                modifier = Modifier
                    .fillMaxSize() // Mengisi ukuran penuh Box
                    .clip(CircleShape),
                imageVector = Icons.Filled.Person,
                contentDescription = "Default profile picture",
                tint = Color.LightGray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPhotoProfile() {
    PhotoProfile(
        modifier = Modifier.size(120.dp) // Memberikan ukuran
    )
}
