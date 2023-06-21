package com.example.shopsmartphone.validator

import android.content.Context
import android.widget.EditText
import com.example.shopsmartphone.R

class Validator(private val context: Context) {
    companion object {
        const val NAME_LENGTH = 1
        const val EMAIL_LENGTH = 8
        const val PASSWORD_LENGTH = 8
        const val EMAIL_TRUE = "@"
         const val PHONE_LENGTH =  11

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

    fun validateFirstName(firstName: EditText): String? =
        when {
            firstName.text.toString().isBlank() -> context.getString(R.string.error_empty)
            firstName.length() <= NAME_LENGTH -> context.getString(R.string.error_username_more4)
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


    fun validateLastName(lastName: EditText): String?=
        when{
            lastName.text.toString().isBlank() -> context.getString(R.string.error_empty)
            lastName.length() <= NAME_LENGTH -> context.getString(R.string.error_username_more4)
            else -> null
        }
    fun validatePhone(phone: EditText): String? =
        when {
            phone.text.toString().isBlank() -> context.getString(R.string.error_empty)
            phone.length() != PHONE_LENGTH -> context.getString(R.string.error_phone_more)
            else -> null
        }


}