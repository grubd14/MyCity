package com.example.mycity

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycity.data.categoriesList
import com.example.mycity.data.recommendationList
import com.example.mycity.ui.CityCategoryScreen
import com.example.mycity.ui.RecommendationScreen

enum class CityHomeScreen(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    Recommended(title = R.string.recommendation_screen),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityAppBar(
    currentScreen: CityHomeScreen,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier
) { Box(
    modifier = modifier
        .fillMaxWidth()
        .size(56.dp),
    contentAlignment = Alignment.Center
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = Modifier
    )
}
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyCityApp(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = CityHomeScreen.valueOf(
        backStackEntry?.destination?.route ?: CityHomeScreen.Home.name
    )
    Scaffold(
        topBar = {
            CityAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                )
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = CityHomeScreen.Home.name
        ) {
            composable(route = CityHomeScreen.Home.name) {
                CityCategoryScreen(
                    navController = navController,
                    categoriesList = categoriesList
                )
            }
            composable(route = CityHomeScreen.Recommended.name) {
                RecommendationScreen(
                    navController = navController,
                    recommendationList = recommendationList
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun CityAppHomeScreen() {
    MyCityApp()
}