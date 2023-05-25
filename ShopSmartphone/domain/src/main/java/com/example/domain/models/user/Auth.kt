package com.example.domain.models.user

import com.google.gson.annotations.SerializedName

data class Auth(


    @SerializedName("email")
    val email:String,
    @SerializedName("password")
    val password: String
)