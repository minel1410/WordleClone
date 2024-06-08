package com.example.wordleclonehackaton.view.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.wordleclonehackaton.repository.Repository
import com.example.wordleclonehackaton.viewmodel.MainViewModel
import com.example.wordleclonehackaton.viewmodel.MainViewModelFactory

@Composable
fun GameScreen(
    navController: NavController
){
    var userGuess by remember { mutableStateOf("") }
    val context = LocalContext.current

    val repository = Repository()
    val viewModel: MainViewModel = viewModel(
        factory = MainViewModelFactory(repository)
    )

    // Prikupljanje stanja iz ViewModel-a
    val guessResponse by viewModel.guessResponse.observeAsState()

    Surface {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row {
                for (i in 0 until 5) {
                    Text(
                        text = if (i < userGuess.length) userGuess[i].toString() else "_",
                        modifier = Modifier.padding(4.dp),
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                // TextField za unos korisničkog guesa
                TextField(
                    value = userGuess,
                    onValueChange = {
                        if (it.length <= 5) {
                            userGuess = it
                        }
                    },
                    label = { Text("Unesite vaš guess") },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Button(onClick = {
                if (userGuess.length < 5) {
                    Toast.makeText(context, "Not enough letters", Toast.LENGTH_SHORT).show()
                } else {
                    viewModel.checkGuess(userGuess)
                }
            }) {
                Text(text = "PROBAJ")
            }

            // Prikaz rezultata
            guessResponse?.let { response ->
                if (!response.isWordInList) {
                    Toast.makeText(context, "Not in word list", Toast.LENGTH_SHORT).show()
                } else {
                    Log.d("Response", response.toString())
                    // Obradi validan odgovor ovde
                }
            }
        }
    }
}

