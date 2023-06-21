package com.example.domain.usecase

import com.example.domain.models.user.Auth
import com.example.domain.repository.IUserLoginRepository

class UserLoginUseCase(private var userLoginRepository: IUserLoginRepository) {
    fun userLogin(user: Auth): String? {
        if (validateLogin(user.email) == null && validatePassword(user.password) == null)
            return userLoginRepository.userLogin(user)
        else
            return "Неправильный логин или пароль"
    }
    fun checkUserLogin(): Boolean {
        return userLoginRepository.checkToken()
    }
    private fun validateLogin(login: String): String? {
        if (login.isEmpty())
            return "Поле для ввода логина пустое"
        else
            return null
    }
    private fun validatePassword(password: String): String? {
        if (password.isEmpty())
            return "Поле для ввода логина пустое"
        else
            return null
    }
}