package com.example.wordleclonehackaton.model

import com.google.gson.annotations.SerializedName

data class CharacterInfo(
    @SerializedName("char") val char: String,
    @SerializedName("scoring") val scoring: Scoring
)