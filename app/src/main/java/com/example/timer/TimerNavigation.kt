package com.example.timer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController

@Composable
fun TimerNavigation(){

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.InitialScreen.route
    ){
        composable(
            route = Screen.InitialScreen.route
        ){
            InitialScreenFun(navController = navController)
        }
        composable(
            route = Screen.SecondScreen.route + "/{count}",
            arguments = listOf(
                navArgument("count"){
                    type = NavType.LongType
                }
            )
        ){ count ->
            TimerSetup(
                timerValue = count.arguments?.getLong("count"),
                buttonColor = Color.Green
            )
        }
    }
}

@Composable
fun Show(count: Long?){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = count.toString(),
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 32.sp
        )
    }
}