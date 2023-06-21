package com.example.domain.models.user

import com.google.gson.annotations.SerializedName

data class UserUpdateProfile(
    @SerializedName("email")
    val email:String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("phoneNumber")
    val phoneNumber: String
)
