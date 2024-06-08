package com.example.wordleclonehackaton.api

import com.example.wordleclonehackaton.model.GuessResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface SimpleApi {

    @GET("/answer")
    suspend fun getAnswer(): String

    @POST("guess")
    suspend fun checkGuess(@Query("word") guess: String): GuessResponse


}