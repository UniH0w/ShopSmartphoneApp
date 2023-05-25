package com.example.shopsmartphone.presentation.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.data.preferencesManager.PreferencesStorage
import com.example.data.storage.ApiService
import com.example.domain.models.user.User
import com.example.domain.models.user.UserUpdateProfile
import com.example.shopsmartphone.R
import com.example.shopsmartphone.presentation.base.BaseFragment
import com.example.shopsmartphone.databinding.FragmentChangeAccountBinding
import com.example.shopsmartphone.validator.Validator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragmentChangeUser : BaseFragment() {
    override val showBottomNavigationView = false
    private lateinit var binding: FragmentChangeAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChangeAccountBinding.inflate(inflater, container, false)
        binding.imageButtonToProfile.setOnClickListener {
           findNavController()
               .navigate(R.id.action_fragmentChangeUser_to_fragmentAccount2)
        }
        binding.saveButtonUser.setOnClickListener {
            updateUser(binding)
        }
        return binding.root
    }

    private fun updateUser(binding: FragmentChangeAccountBinding) {

        val emailInputLayout = binding.inputLayoutChangeEmail
        val firsNameInputLayout = binding.inputLayoutChangeName
        val lastNameInputLayout = binding.inputLayoutChangeFamily
        val phoneNumberInputLayout = binding.inputLayoutChangeNumberPhone
        val validate = Validator(context = requireContext())
        val preferencesStorage = PreferencesStorage(context = requireContext())

        firsNameInputLayout.error = validate.validateFirstName(binding.editTextChangeName)
        lastNameInputLayout.error = validate.validateLastName(binding.editTextChangeFamily)
        phoneNumberInputLayout.error = validate.validatePhone(binding.editTextChangeNumberPhone)
        emailInputLayout.error = validate.validateLogin(binding.editTextChangeEmail)


        if (firsNameInputLayout.error == null &&
            lastNameInputLayout.error == null &&
            emailInputLayout.error == null &&
            phoneNumberInputLayout.error == null
        ) {
            ApiService.retrofit.userUpdate(
                UserUpdateProfile(
                    binding.editTextChangeEmail.text.toString(),
                    binding.editTextChangeName.text.toString(),
                    binding.editTextChangeFamily.text.toString(),
                    binding.editTextChangeNumberPhone.text.toString()
                ),
                "Bearer ${preferencesStorage.readLoginPreference()}"
            ).enqueue(
                object : Callback<User> {
                    override fun onResponse(call: Call<User>, response: Response<User>) {

                        if (response.isSuccessful) {
                            val name = binding.editTextChangeName
                            val lastName = binding.editTextChangeFamily
                            val email = binding.editTextChangeEmail
                            preferencesStorage.writeFirstNamePreference(name.text.toString())
                            preferencesStorage.writeLastNamePreference(lastName.text.toString())
                            preferencesStorage.writeEmailPreference(email.text.toString())
                            Toast.makeText(activity,"Save",Toast.LENGTH_SHORT).show()
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