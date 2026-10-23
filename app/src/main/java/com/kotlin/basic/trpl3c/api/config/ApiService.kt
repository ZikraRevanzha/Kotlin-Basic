package com.kotlin.basic.trpl3c.api.config

import com.kotlin.basic.trpl3c.api.models.CategoryModel
import com.kotlin.basic.trpl3c.api.models.ProductModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    // Mengambil Category dari The Meal
    @GET("api/json/v1/1/categories.php")
    fun getCategory(): Call<CategoryModel>

    @GET("products")
    fun getProduct(): Call<ProductModel>
}