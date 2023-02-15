package com.example.mycity.data

import com.example.mycity.R

data class RecommendedPlaces(
    val image: Int,
    val text: Int
)

val recommendationList = listOf(
    RecommendedPlaces(R.drawable.category_test, R.string.text_1),
    RecommendedPlaces(R.drawable.category_test1, R.string.text_2),
    RecommendedPlaces(R.drawable.category_test2, R.string.text_3),
    RecommendedPlaces(R.drawable.category_test3, R.string.text_4),
    )