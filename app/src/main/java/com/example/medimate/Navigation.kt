package com.example.medimate

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.medimate.screen.add.AddMedicine
import com.example.medimate.screen.home.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController = navController)
        }
        composable(route = Screen.ReminderScreen.route){
            AddMedicine(navController = navController)
        }
    }
}