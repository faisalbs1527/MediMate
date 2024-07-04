package com.example.medimate

sealed class Screen(val route: String) {
    object HomeScreen: Screen(route = "HomeScreen")
    object ReminderScreen: Screen(route = "AddMedicine")
}