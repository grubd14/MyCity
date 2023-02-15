
package com.example.mycity.data
import com.example.mycity.R

data class Categories(
    val image: Int,
    val headline: Int,
    val body: Int,
)

val categoriesList = listOf(
    Categories(R.drawable.coffee_shop, R.string.headline_1, R.string.body_1),
    Categories(R.drawable.restaurant, R.string.headline_2, R.string.body_2),
    Categories(R.drawable.kid_friendly, R.string.headline_3, R.string.body_3),
    Categories(R.drawable.park, R.string.headline_4, R.string.body_4),
    Categories(R.drawable.shopping_center, R.string.headline_5, R.string.body_5)
)
