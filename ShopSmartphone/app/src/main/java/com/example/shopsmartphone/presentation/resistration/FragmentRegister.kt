package com.example.shopsmartphone.presentation.resistration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.data.preferencesManager.PreferencesStorage
import com.example.data.storage.ApiService
import com.example.domain.models.user.User
import com.example.domain.models.user.UserCreate
import com.example.shopsmartphone.R
import com.example.shopsmartphone.presentation.base.BaseFragment
import com.example.shopsmartphone.databinding.FragmentRegisterBinding
import com.example.shopsmartphone.validator.Validator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentRegister: BaseFragment() {
    lateinit var binding: FragmentRegisterBinding
    override val showBottomNavigationView = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.registerButton.setOnClickListener {
         signIn(binding)
        }
        return binding.root
    }


    private fun signIn(binding: FragmentRegisterBinding) {

            val emailInputLayout = binding.inputLayoutEmail
            val passwordInputLayout = binding.inputLayoutPassword
            val firsNameInputLayout = binding.inputLayoutFirstName
            val lastNameInputLayout = binding.inputLayoutLastName
            val phoneNumberInputLayout = binding.inputLayoutPhoneNumber
            val confirmPasswordInputLayout = binding.inputLayoutConfirmPassword
            val validate = Validator(context = requireContext())
            val preferencesStorage = PreferencesStorage(requireContext())

            firsNameInputLayout.error = validate.validateFirstName(binding.editTextFirstName)
            lastNameInputLayout.error = validate.validateLastName(binding.editTextLastName)
            phoneNumberInputLayout.error = validate.validatePhone(binding.editTextPhoneNumber)
            emailInputLayout.error = validate.validateLogin(binding.editTextEmail)
            passwordInputLayout.error = validate.validatePassword(binding.editTextPassword)
            confirmPasswordInputLayout.error = validate.confirmPassword(
                binding.editTextPassword,
                binding.editTextConfirmPassword
            )

            if (firsNameInputLayout.error == null &&
                lastNameInputLayout.error == null &&
                emailInputLayout.error == null &&
                phoneNumberInputLayout.error == null &&
                passwordInputLayout.error == null &&
                confirmPasswordInputLayout.error == null
            ) {
                ApiService.retrofit.userCreate(
                    UserCreate(
                        binding.editTextEmail.text.toString(),
                        binding.editTextFirstName.text.toString(),
                        binding.editTextLastName.text.toString(),
                        binding.editTextPassword.text.toString(),
                        binding.editTextPhoneNumber.text.toString()
                    )
                ).enqueue(
                    object : Callback<User> {
                        override fun onResponse(call: Call<User>, response: Response<User>) {

                            if (response.isSuccessful) {
                                val token = response.body()?.token
                                preferencesStorage.writeLoginPreference(token.toString())

                                findNavController()
                                    .navigate(R.id.action_fragmentRegister_to_fragmentRegisterOk)


                            } else {
                                Toast.makeText(
                                    activity,
                                    getString(R.string.login_bad_request),
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
