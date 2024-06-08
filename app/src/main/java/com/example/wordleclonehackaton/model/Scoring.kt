package com.example.wordleclonehackaton.model

import com.google.gson.annotations.SerializedName

data class Scoring(
    @SerializedName("in_word") val inWord: Boolean,
    @SerializedName("correct_idx") val correctIdx: Boolean
)