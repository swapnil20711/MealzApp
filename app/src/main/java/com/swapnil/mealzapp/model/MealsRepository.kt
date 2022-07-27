package com.swapnil.mealzapp.model

import com.swapnil.mealzapp.model.api.MealsApiService
import com.swapnil.mealzapp.model.response.MealResponse

class MealsRepository(private val webService: MealsApiService = MealsApiService()) {
    suspend fun getMeals():MealResponse {
        return webService.getMeals()
    }
}