package com.example.mycity.ui
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycity.data.RecommendedPlaces
import com.example.mycity.data.recommendationList

@Composable
fun RecommendationScreen(
    recommendationList: List<RecommendedPlaces>,
    navController: NavController,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        modifier = Modifier

    ) {
        items(recommendationList.size) { index ->
    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        modifier = Modifier
            .padding(10.dp)
            .height(180.dp)
            .wrapContentHeight(align = Alignment.Bottom)

    ) {
        Box(
            modifier = Modifier
        ) {
            Image(
                painter = painterResource(recommendationList[index].image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp))
                    .padding(4.dp)

            )
            Text(
                text = stringResource(recommendationList[index].text),
                color = Color.White,
                fontWeight = FontWeight(400),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 16.dp, bottom = 14.dp)
                    .align(Alignment.BottomStart)
            )
        }

        }
    }

    }
}

@Preview(showBackground = false)
@Composable
fun CityAppRecommendationScreen() {
}