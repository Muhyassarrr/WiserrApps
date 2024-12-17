package com.example.wiserrapps.ui.screen.laporan.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wiserrapps.data.Data.dataProduksi

@Composable
fun GrafikProduksi(){

    val maxValue = 10f
    val yAxisRange = (0..10 step 2).reversed()
    Text(
        text = "Grafik Produksi",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(horizontal = 8.dp)
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(8.dp)),
            colors = CardDefaults
                .cardColors(
                containerColor = Color.White)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    yAxisRange.forEach { number ->
                        Text(
                            text = number.toString(),
                            fontSize = 12.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                    }
                }
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 32.dp, bottom = 5.dp, end = 16.dp)
                ) {
                    val width = size.width
                    val height = size.height
                    val lineSpacing = height / (yAxisRange.count() - 1)

                    yAxisRange.forEachIndexed { index, _ ->
                        val y = index * lineSpacing
                        drawLine(
                            color = Color(0xFFE5E7EB),
                            start = Offset(0f, y),
                            end = Offset(width, y),
                            strokeWidth = 1.dp.toPx()
                        )
                    }
                    val points = dataProduksi.mapIndexed { index, data ->
                        val x = width * (index.toFloat() / (dataProduksi.size - 1))
                        val y = height - (data.jumlah / maxValue) * height // Adjusted y calculation
                        Offset(x, y)
                    }

                    for (i in 0 until points.size - 1) {
                        drawLine(
                            color = Color(0xFF60A5FA),
                            start = points[i],
                            end = points[i + 1],
                            strokeWidth = 2.dp.toPx()
                        )
                    }
                    points.forEachIndexed { index, point ->
                        drawCircle(
                            color = Color.White,
                            radius = 4.dp.toPx(),
                            center = point,
                            style = Stroke(width = 2.dp.toPx())
                        )
                        drawCircle(
                            color = Color(0xFF60A5FA),
                            radius = 3.dp.toPx(),
                            center = point
                        )
                        drawContext.canvas.nativeCanvas.apply {
                            drawText(
                                dataProduksi[index].jumlah.toString(),  // Display actual data value
                                point.x,
                                point.y - 10.dp.toPx(),
                                android.graphics.Paint().apply {
                                    color = android.graphics.Color.GRAY
                                    textSize = 10.sp.toPx()
                                    textAlign = android.graphics.Paint.Align.CENTER
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GrafikKeuangan(){

    val maxValue = 10f
    val yAxisRange = (0..10 step 2).reversed()
    Text(
        text = "Grafik Keuangan",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(horizontal = 8.dp)
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(8.dp)),
            colors = CardDefaults
                .cardColors(
                    containerColor = Color.White)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    yAxisRange.forEach { number ->
                        Text(
                            text = number.toString(),
                            fontSize = 12.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                    }
                }
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 32.dp, bottom = 5.dp, end = 16.dp)
                ) {
                    val width = size.width
                    val height = size.height
                    val lineSpacing = height / (yAxisRange.count() - 1)

                    yAxisRange.forEachIndexed { index, _ ->
                        val y = index * lineSpacing
                        drawLine(
                            color = Color(0xFFE5E7EB),
                            start = Offset(0f, y),
                            end = Offset(width, y),
                            strokeWidth = 1.dp.toPx()
                        )
                    }
                    val points = dataProduksi.mapIndexed { index, data ->
                        val x = width * (index.toFloat() / (dataProduksi.size - 1))
                        val y = height - (data.jumlah / maxValue) * height // Adjusted y calculation
                        Offset(x, y)
                    }

                    for (i in 0 until points.size - 1) {
                        drawLine(
                            color = Color(0xFF60A5FA),
                            start = points[i],
                            end = points[i + 1],
                            strokeWidth = 2.dp.toPx()
                        )
                    }
                    points.forEachIndexed { index, point ->
                        drawCircle(
                            color = Color.White,
                            radius = 4.dp.toPx(),
                            center = point,
                            style = Stroke(width = 2.dp.toPx())
                        )
                        drawCircle(
                            color = Color(0xFF60A5FA),
                            radius = 3.dp.toPx(),
                            center = point
                        )
                        drawContext.canvas.nativeCanvas.apply {
                            drawText(
                                dataProduksi[index].jumlah.toString(),  // Display actual data value
                                point.x,
                                point.y - 10.dp.toPx(),
                                android.graphics.Paint().apply {
                                    color = android.graphics.Color.GRAY
                                    textSize = 10.sp.toPx()
                                    textAlign = android.graphics.Paint.Align.CENTER
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

