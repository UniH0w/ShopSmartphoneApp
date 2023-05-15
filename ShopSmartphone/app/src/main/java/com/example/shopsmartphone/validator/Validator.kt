package com.example.shopsmartphone.validator

import android.content.Context
import android.widget.EditText
import com.example.shopsmartphone.R

class Validator(private val context: Context) {
    companion object {
        const val USERNAME_LENGTH = 4
        const val EMAIL_LENGTH = 8
        const val PASSWORD_LENGTH = 8
        const val EMAIL_TRUE = "@"
    }
    fun validateLogin(login: EditText): String? =
        when{
            login.text.toString().isBlank() -> context.getString(R.string.error_empty)
            login.length() <= EMAIL_LENGTH -> context.getString(R.string.error_email_more8)
            !(login.text.toString().contains(EMAIL_TRUE)) -> {
                context.getString(R.string.error_email_true)
            }
            else -> null
        }

    fun validateUsername(username: EditText): String? =
        when {
            username.text.toString().isBlank() -> context.getString(R.string.error_empty)
            username.length() <= USERNAME_LENGTH -> context.getString(R.string.error_username_more4)
            else -> null
        }

    fun validatePassword(password: EditText): String? =
        when {
            password.text.toString().isBlank() -> context.getString(R.string.error_empty)
            password.length() <= PASSWORD_LENGTH -> context.getString(R.string.error_email_more8)
            else -> null
        }

    fun confirmPassword(password: EditText, confirmPassword: EditText): String? =
        when {
            confirmPassword.text.toString().isBlank() -> context.getString(R.string.error_empty)
            password.length() < 1 -> context.getString(R.string.error_empty)
            password.text.toString() != confirmPassword.text.toString() ->
                context.getString(R.string.error_confirm)
            else -> null
        }
}