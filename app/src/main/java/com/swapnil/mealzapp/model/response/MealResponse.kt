package com.swapnil.mealzapp.model.response

data class MealResponse(
    val categories: List<MealCategory>
)

data class MealCategory(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)