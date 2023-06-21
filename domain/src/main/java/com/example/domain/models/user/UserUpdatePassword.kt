package com.example.domain.models.user

import com.google.gson.annotations.SerializedName

data class UserUpdatePassword(
    @SerializedName("newPassword")
    val password: String
)
