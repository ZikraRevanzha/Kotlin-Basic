package com.kotlin.basic.trpl3c.api.models

data class ProductModel(
    val products: List<Product>
) {
    data class Product(
        val id: Int,
        val images: List<String>,
        val title: String,
        val price: Double,
        val rating: Double
    )
}
