package com.example.timer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun InitialScreenFun(navController: NavController){

    var count by remember {
        mutableStateOf("")
    }

    var scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            OutlinedTextField(
                value = count,
                onValueChange = {
                    count = it
                }
            )
            Button(
                onClick = {
                    if (count.isEmpty()){
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Please put Number!!")
                        }
                    } else {
                        navController.navigate(Screen.SecondScreen.withArgs(count))
                    }
                }
            ) {
                Text(
                    text = "Next",
                    color = Color.White,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}