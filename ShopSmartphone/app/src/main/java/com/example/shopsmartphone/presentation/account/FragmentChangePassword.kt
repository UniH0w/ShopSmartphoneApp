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
import com.example.domain.models.user.UserUpdatePassword
import com.example.shopsmartphone.R
import com.example.shopsmartphone.presentation.base.BaseFragment
import com.example.shopsmartphone.databinding.FragmentChangeYourPasswordBinding
import com.example.shopsmartphone.validator.Validator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentChangePassword : BaseFragment() {
    override val showBottomNavigationView = false
    private lateinit var binding: FragmentChangeYourPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChangeYourPasswordBinding.inflate(inflater, container, false)
        binding.imageButton.setOnClickListener {
            findNavController()
                .navigate(R.id.action_fragmentChangePassword_to_fragmentAccount2)
        }

        binding.saveButton.setOnClickListener {
            updateUserPassword(binding)
        }
        return binding.root
    }

    private fun updateUserPassword(binding: FragmentChangeYourPasswordBinding) {

        val password =binding.inputLayoutChangeNewPassword
        val validate = Validator(context = requireContext())
        val preferencesStorage = PreferencesStorage(context = requireContext())

        password.error = validate.validatePassword(binding.editTextChangeNewPassword)

        if (
            password.error == null

        ) {
            ApiService.retrofit.userUpdatePassword(
                UserUpdatePassword(
                    binding.editTextChangeNewPassword.text.toString()
                ),
                "Bearer ${preferencesStorage.readLoginPreference()}"
            ).enqueue(
                object : Callback<User> {
                    override fun onResponse(call: Call<User>, response: Response<User>) {

                        if (response.isSuccessful) {

                            Toast.makeText(activity,"Save",Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(
                                activity,
                                "Проблема при измение пароля",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<User>, t: Throwable) {
                        Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }else{
            Toast.makeText(activity,"Eror",Toast.LENGTH_SHORT)
        }
    }
}