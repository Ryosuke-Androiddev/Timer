package com.example.timer

sealed class Screen(val route: String){

    object InitialScreen: Screen("initial_screen")
    object SecondScreen: Screen("second_screen")

    fun withArgs(vararg count: String): String{
        return buildString {
            append(route)
            count.forEach { value ->
                append("/$value")
            }
        }
    }
}
