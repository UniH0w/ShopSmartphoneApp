package com.example.domain.repository

import com.example.domain.models.user.Auth


interface IUserLoginRepository {
    fun userLogin(auth: Auth): String?
    fun checkToken(): Boolean
}