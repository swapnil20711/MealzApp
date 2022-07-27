package com.swapnil.mealzapp.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swapnil.mealzapp.model.MealsRepository
import com.swapnil.mealzapp.model.response.MealCategory
import com.swapnil.mealzapp.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {
    var mealState: MutableState<List<MealCategory>> =
        mutableStateOf(emptyList<MealCategory>())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMeals()
            mealState.value = meals.categories
        }
    }

    suspend fun getMeals(): MealResponse {
        return repository.getMeals()
    }
}