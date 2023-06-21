package com.example.domain.models.user

import com.google.gson.annotations.SerializedName
import java.net.PasswordAuthentication

data class User(
    @SerializedName("email")
    val email:String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("token")
    val  token: String

)