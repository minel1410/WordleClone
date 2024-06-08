package com.example.wordleclonehackaton.model

import com.google.gson.annotations.SerializedName

data class GuessResponse(
    @SerializedName("guess") val guess: String,
    @SerializedName("is_correct") val isCorrect: Boolean,
    @SerializedName("is_word_in_list") val isWordInList: Boolean,
    @SerializedName("character_info") val characterInfo: List<CharacterInfo>? = null
)