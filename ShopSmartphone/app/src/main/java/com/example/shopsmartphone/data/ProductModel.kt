package com.example.shopsmartphone.data

import java.io.Serializable

data class ProductModel(
    val id: Int,
    val manufacturer: String,
    val description: String,
    val price: String,
    val icon: String
): Serializable
