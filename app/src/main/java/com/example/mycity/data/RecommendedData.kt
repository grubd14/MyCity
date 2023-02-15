package com.example.mycity.data

import com.example.mycity.R

data class RecommendedPlaces(
    val image: Int,
    val text: Int
)

val recommendationList = listOf(
    RecommendedPlaces(R.drawable.reco_coffee, R.string.text_1),
    RecommendedPlaces(R.drawable.reco_coffee_1, R.string.text_2),
    RecommendedPlaces(R.drawable.reco_coffee_2, R.string.text_3),
    RecommendedPlaces(R.drawable.reco_coffee_3, R.string.text_4),
    RecommendedPlaces(R.drawable.reco_coffee_4,R.string.text_5)
    )