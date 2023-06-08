package com.example.data.preferencesManager

import android.content.Context


class PreferencesStorage(private val context: Context) {
    companion object {
        private const val PREFERENCE_TOKEN = "token"
        private const val KEY_TOKEN = "TOKEN"
        private const val PREFERENCE_FIRSTNAME = "name"
        private const val PREFERENCE_LASTNAME = "lastname"
        private const val NAME = "NAME"
        private const val LASTNAME ="LASTNAME"
        private const val EMAIL ="EMAIL"
        private const val PREFERENCE_EMAIL = "EMAIL"
        private const val PREFERENCE_PHONE = "89876946171"
        private const val PHONE ="89876946171"


    }

    fun writeLoginPreference(token: String) {

        val preference = context.getSharedPreferences(PREFERENCE_TOKEN, Context.MODE_PRIVATE)
        preference.edit().putString(KEY_TOKEN, token).apply()
    }
    fun readLoginPreference(): String {

        val preference = context.getSharedPreferences(PREFERENCE_TOKEN, Context.MODE_PRIVATE)
        return preference.getString(KEY_TOKEN, null) ?: ""
    }


    fun writePhonePreference(phoneNumber: String) {

        val preference = context.getSharedPreferences(PREFERENCE_PHONE, Context.MODE_PRIVATE)
        preference.edit().putString(PHONE, phoneNumber).apply()
    }
    fun readPhonePreference(): String {

        val preference = context.getSharedPreferences(PREFERENCE_PHONE, Context.MODE_PRIVATE)
        return preference.getString(PHONE, null) ?: ""
    }



    fun deleteLoginPreference() {
        val preference = context.getSharedPreferences(PREFERENCE_TOKEN, Context.MODE_PRIVATE)
        preference.edit().clear().apply()
    }

        //Хранение почты
    fun writeEmailPreference(email: String) {
            val preference = context.getSharedPreferences(PREFERENCE_EMAIL, Context.MODE_PRIVATE)
            preference.edit().putString(EMAIL, email).apply()
        }

        fun readEmailPreference(): String {
            val preference = context.getSharedPreferences(PREFERENCE_EMAIL, Context.MODE_PRIVATE)
            return preference.getString(EMAIL, null) ?: ""
        }


    //Хранение Имени
    fun writeFirstNamePreference(firstName: String) {
        val preference = context.getSharedPreferences(PREFERENCE_FIRSTNAME, Context.MODE_PRIVATE)
        preference.edit().putString(NAME, firstName).apply()

    }
    fun readFirstNamePreference(): String {
        val preference = context.getSharedPreferences(PREFERENCE_FIRSTNAME, Context.MODE_PRIVATE)
        return preference.getString(NAME, null) ?: ""
    }

    //Хранение Фамилия
    fun writeLastNamePreference(lastName: String){
        val preferences = context.getSharedPreferences(PREFERENCE_LASTNAME, Context.MODE_PRIVATE)
        preferences.edit().putString(LASTNAME, lastName).apply()
    }
    fun readLastNamePreference(): String {
        val preference = context.getSharedPreferences(PREFERENCE_LASTNAME, Context.MODE_PRIVATE)
        return preference.getString(LASTNAME, null) ?: ""
    }


    fun deleteFirsNamePreference() {
        val preference = context.getSharedPreferences(PREFERENCE_FIRSTNAME, Context.MODE_PRIVATE)
        preference.edit().clear().apply()
    }

    fun deleteLastNamePreference() {
        val preference = context.getSharedPreferences(PREFERENCE_LASTNAME, Context.MODE_PRIVATE)
        preference.edit().clear().apply()
    }
    fun deleteEmailPreference() {
        val preference = context.getSharedPreferences(PREFERENCE_EMAIL, Context.MODE_PRIVATE)
        preference.edit().clear().apply()
    }

}