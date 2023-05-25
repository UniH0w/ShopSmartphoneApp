package com.example.domain.models.user

import com.google.gson.annotations.SerializedName

data class UserCreate(
    @SerializedName("email")
    val email:String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("password")
    val password:String,
    @SerializedName("phoneNumber")
    val phoneNumber: String
)