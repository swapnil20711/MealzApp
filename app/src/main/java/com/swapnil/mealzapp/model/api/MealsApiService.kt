package com.swapnil.mealzapp.model.api

import com.swapnil.mealzapp.model.response.MealResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


class MealsApiService {
    private lateinit var api: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        api = retrofit.create(MealsApi::class.java)
    }

    suspend fun getMeals(): MealResponse = api.getMeals()

    interface MealsApi {
        @GET("categories.php")
        suspend fun getMeals(): MealResponse
    }
}