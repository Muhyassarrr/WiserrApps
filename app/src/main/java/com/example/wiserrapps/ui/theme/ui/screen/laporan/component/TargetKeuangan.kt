package com.example.wiserrapps.ui.theme.ui.screen.laporan.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TargetKeuangan(){
    Column(
        modifier = Modifier
            .padding(vertical = 10.dp)
    ){
        Text(
            text = "Target Keuangan",
            color = Color.Black,
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold),
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .padding(top = 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFE8F1F9)
            )
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box(
                    modifier = Modifier.size(60.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Canvas(
                        modifier = Modifier.size(60.dp)
                    ) {
                        val strokeWidth = 12.dp.toPx()
                        val center = Offset(size.width / 2, size.height / 2)
                        val radius = (size.width - strokeWidth) / 2

                        // Background Circle
                        drawArc(
                            color = Color(0xFFE2E8F0),
                            startAngle = 0f,
                            sweepAngle = 360f,
                            useCenter = false,
                            style = Stroke(width = strokeWidth),
                            size = Size(radius * 2, radius * 2),
                            topLeft = Offset(strokeWidth / 2, strokeWidth / 2)
                        )

                        // Progress Arc
                        drawArc(
                            color = Color(0xFF60A5FA),
                            startAngle = -90f,
                            sweepAngle = 30f * 360f, // 0% progress
                            useCenter = false,
                            style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                            size = Size(radius * 2, radius * 2),
                            topLeft = Offset(strokeWidth / 2, strokeWidth / 2)
                        )
                    }

                    Text(
                        text = "0%",
                        color = Color(0xFF1E40AF),
                        fontWeight = FontWeight.Medium
                    )
                }

                Column {
                    Text(
                        text = "Keuntungan Bulanan",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF1F2937)
                    )
                    Text(
                        text = "Keuntungan yang didapatkan Rp. 20.000.000,00 dari Rp. 40.000.000,00",
                        fontSize = 14.sp,
                        color = Color(0xFF4B5563)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previeww(){
    TargetKeuangan()
}