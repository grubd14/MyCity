package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycity.CityHomeScreen
import com.example.mycity.data.Categories
import com.example.mycity.data.categoriesList

@Composable
fun CityCategoryScreen(
    navController: NavController,
    categoriesList: List<Categories>,
    modifier: Modifier = Modifier
    ) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        modifier = Modifier
    ) {
        items(categoriesList.size) {index ->
        Card(
            modifier = Modifier
                .padding(8.dp)
                .clickable(onClick = { navController.navigate(CityHomeScreen.Recommended.name)}),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                ) {
                    Box(
                        modifier = Modifier
                            .size(96.dp)
                            .clip(RoundedCornerShape(8.dp))
                    ) {
                        Image(
                            painter = painterResource(categoriesList[index].image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,

                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .width(4.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp)
                ) {
                    Text(
                        text = stringResource(categoriesList[index].headline),
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight(550)
                    )
                    Text(
                        text = stringResource(categoriesList[index].body),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                }
            }
        }

    }
}

@Preview(showBackground = false)
@Composable
fun CityAppHomeScreen() {
}