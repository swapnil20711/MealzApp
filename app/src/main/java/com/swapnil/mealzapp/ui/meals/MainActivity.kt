package com.swapnil.mealzapp.ui.meals

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.swapnil.mealzapp.ui.components.CircularLoader
import com.swapnil.mealzapp.ui.components.MealsCategoriesCard
import com.swapnil.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                Surface(color = Color.LightGray) {
                    MealsCategoriesScreen()
                }
            }
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MealsCategoriesScreen() {
    /*Binds the viewModel with the constructor*/
    val viewModel: MealsCategoriesViewModel = viewModel()
    val meals = viewModel.mealState.value
    LazyColumn() {
        items(meals) { meal ->
            MealsCategoriesCard(meal = meal)
        }
    }
    CircularLoader(isLoading = viewModel.isLoadingState.value)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealsCategoriesScreen()
    }
}