package com.example.wordleclonehackaton.view.screens

sealed class Screen(val route: String) {

    object Start: Screen(route = "start_screen")
    object Game: Screen(route = "game_screen")
    object Stats: Screen(route = "stats_screen")
}