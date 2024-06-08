package com.example.wordleclonehackaton.repository

import com.example.wordleclonehackaton.api.RetrofitInstance
import com.example.wordleclonehackaton.model.GuessResponse

class Repository {

    suspend fun getAnswer(): String {
        return RetrofitInstance.api.getAnswer()
    }

    suspend fun checkGuess(guess: String): GuessResponse {
        return RetrofitInstance.api.checkGuess(guess)
    }


}