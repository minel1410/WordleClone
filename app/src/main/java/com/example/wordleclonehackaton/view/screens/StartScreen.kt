package com.example.wordleclonehackaton.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun StartScreen(
    navController: NavController
){
    Button(onClick = { navController.navigate(Screen.Game.route) }) {
        Text(text = "PREDJI NA GAME")
    }
}