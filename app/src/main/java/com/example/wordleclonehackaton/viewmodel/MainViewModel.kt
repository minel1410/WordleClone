package com.example.wordleclonehackaton.viewmodel

import android.net.http.HttpException
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wordleclonehackaton.model.GuessResponse
import com.example.wordleclonehackaton.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    private val _guessResponse = MutableLiveData<GuessResponse>()
    val answerResponse: MutableLiveData<String> = MutableLiveData()
    val guessResponse: LiveData<GuessResponse> get() = _guessResponse


    fun getWord() {
        viewModelScope.launch {
            val response : String = repository.getAnswer()
            answerResponse.value = response
        }
    }

    fun checkGuess(guess: String) {
        viewModelScope.launch {
            val response: GuessResponse = repository.checkGuess(guess)
            _guessResponse.value = response

        }
    }
}