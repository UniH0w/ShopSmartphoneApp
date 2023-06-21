package com.example.shopsmartphone.presentation.login


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.data.preferencesManager.PreferencesStorage

import com.example.data.storage.ApiService
import com.example.domain.models.user.User
import com.example.domain.models.user.Auth
import com.example.shopsmartphone.R
import com.example.shopsmartphone.presentation.base.BaseFragment
import com.example.shopsmartphone.databinding.FragmentLoginBinding
import com.example.shopsmartphone.validator.Validator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection


class FragmentLogin: BaseFragment() {

    lateinit var binding: FragmentLoginBinding
    override val showBottomNavigationView = false




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.continueButton.setOnClickListener {
            findNavController()
                .navigate(R.id.action_fragmentLogin_to_fragmentRegister)
        }

        binding.signInButton.setOnClickListener {
            signInUser(binding)
        }
        return binding.root
    }
    private fun signInUser(binding: FragmentLoginBinding) {
        val email = binding.editTextEmailLogin
        val password = binding.editTextPasswordLogin
        val emailInputLayout = binding.inputLayoutEmailLogin
        val passwordInputLayout = binding.inputLayoutPasswordLogin
        val validate = Validator(context = requireContext())
        val preferencesStorage = PreferencesStorage(requireContext())
        emailInputLayout.error = validate.validateLogin(email)
        passwordInputLayout.error = validate.validatePassword(password)


        if (emailInputLayout.error == null &&
            passwordInputLayout.error == null
        ) {
            ApiService.retrofit.userLogin(
                Auth(
                    email.text.toString(),
                    password.text.toString()

                )
            ).enqueue(
                object : Callback<User> {
                    override fun onResponse(call: Call<User>, response: Response<User>) {

                        when (response.code()) {
                            HttpURLConnection.HTTP_OK -> {
                                val token = response.body()?.token
                                val  firstName = response.body()?.firstName
                                val lastName = response.body()?.lastName
                                val email = response.body()?.email
                                val phoneNumber = response.body()?.phoneNumber
                                preferencesStorage.writeLoginPreference(token.toString())
                                preferencesStorage.writeFirstNamePreference(firstName.toString())
                                preferencesStorage.writeLastNamePreference(lastName.toString())
                                preferencesStorage.writeEmailPreference(email.toString())
                                preferencesStorage.writePhonePreference(phoneNumber.toString())
                                findNavController()
                                    .navigate(R.id.action_fragmentLogin_to_search_graph)
                            }

                            HttpURLConnection.HTTP_BAD_REQUEST -> Toast.makeText(
                                activity,
                                getString(R.string.login_bad_request),
                                Toast.LENGTH_SHORT
                            ).show()

                            HttpURLConnection.HTTP_UNAUTHORIZED -> Toast.makeText(
                                activity,
                                getString(R.string.login_unauthorized),
                                Toast.LENGTH_SHORT
                            ).show()

                            else -> Toast.makeText(
                                activity,
                                getString(R.string.request_error),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<User>, t: Throwable) {
                        Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()
                    }


                }
            )
        }
    }
}







