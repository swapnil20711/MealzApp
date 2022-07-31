package com.swapnil.mealzapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.swapnil.mealzapp.model.response.MealCategory

@Composable
fun CircularLoader(isLoading: Boolean) {
    if (isLoading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicatorcolor = Color.Green)
        }
    }
}

@Composable
fun MealsCategoriesCard(meal: MealCategory) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), elevation = 8.dp, shape = AbsoluteCutCornerShape(topRight = 16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Card(
                shape = CircleShape, modifier = Modifier
                    .size(72.dp)
                    .padding(8.dp)
            ) {
                SubcomposeAsyncImage(
                    model = meal.strCategoryThumb,
                    contentScale = ContentScale.Crop,
                    loading = {
                        CircularProgressIndicator()
                    },
                    contentDescription = "Image of " + meal.strCategory
                )
            }
            Text(text = meal.strCategory, style = MaterialTheme.typography.h5)
        }
    }
}