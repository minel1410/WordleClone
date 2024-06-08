package com.example.wordleclonehackaton.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wordleclonehackaton.view.screens.GameScreen
import com.example.wordleclonehackaton.view.screens.Screen
import com.example.wordleclonehackaton.view.screens.StartScreen
import com.example.wordleclonehackaton.view.screens.StatsScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Start.route
    ) {
        composable(
            route = Screen.Start.route
        ) {
            StartScreen(navController = navController)
        }
        composable(
            route = Screen.Game.route,
        ) {
            GameScreen(navController = navController)
        }
        composable(
            route = Screen.Stats.route
        ) {
            StatsScreen(navController = navController)
        }
    }
}