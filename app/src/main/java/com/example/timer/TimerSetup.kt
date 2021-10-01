package com.example.timer

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun TimerSetup(
    timerValue: Long?,
    buttonColor: Color
){
    var currentTime by remember {
        mutableStateOf(timerValue!!)
    }

    var isTimerRunning by remember {
        mutableStateOf(false)
    }

    var progress by remember {mutableStateOf(1f)}

    LaunchedEffect(key1 = isTimerRunning) {
        if(isTimerRunning) {
            delay(1000L)
            currentTime -= 1000L
        }
    }

    LaunchedEffect(key1 = progress, key2 = isTimerRunning) {
        if(progress>=0 && isTimerRunning) {
            delay(1000L)
            progress -= 0.01F
        }
    }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = currentTime.toString(),
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            LinearProgressIndicator(
                color = Color.Black,
                backgroundColor = LightGray,
                progress = progress
            )

            Spacer(modifier = Modifier.padding(16.dp))
            
            Button(
                onClick = {
                    if (currentTime <= 0L){
                        isTimerRunning = true
                    } else {
                        isTimerRunning = !isTimerRunning
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (!isTimerRunning){
                        Color.Green
                    } else {
                        Color.Red
                    }
                )
            ) {
                Icon(
                    Icons.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text =
                    if (isTimerRunning) "Stop"
                    else "Start"
                )
            }

    }
}