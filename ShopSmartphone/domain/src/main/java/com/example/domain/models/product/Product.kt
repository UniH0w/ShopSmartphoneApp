package com.example.domain.models.product

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id")
    val id: String,
    @SerializedName("manufacturer")
    val manufacturer: String,
    @SerializedName("model")
    val model: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: String
)
