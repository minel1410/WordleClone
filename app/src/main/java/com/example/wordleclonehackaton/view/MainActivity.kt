package com.example.wordleclonehackaton.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wordleclonehackaton.R
import com.example.wordleclonehackaton.repository.Repository
import com.example.wordleclonehackaton.view.navigation.SetupNavGraph
import com.example.wordleclonehackaton.view.screens.StartScreen
import com.example.wordleclonehackaton.view.screens.GameScreen
import com.example.wordleclonehackaton.view.theme.WordleCloneHackatonTheme
import com.example.wordleclonehackaton.viewmodel.MainViewModel
import com.example.wordleclonehackaton.viewmodel.MainViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var navController: NavHostController

    private var backPressedOnce = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            WordleCloneHackatonTheme {
                navController = rememberNavController()

                SetupNavGraph(navController = navController)

                BackHandler(enabled = true) {
                    if (backPressedOnce) {
                        finish()
                    } else {
                        Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()
                        backPressedOnce = true
                        CoroutineScope(Dispatchers.Main).launch {
                            delay(5_000)
                            backPressedOnce = false
                        }

                    }
                }
            }
        }

    }
}

