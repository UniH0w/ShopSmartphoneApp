package com.example.shopsmartphone.presentation.resistration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shopsmartphone.R
import com.example.shopsmartphone.presentation.base.BaseFragment
import com.example.shopsmartphone.databinding.FragmentRegisterBinding
import com.example.shopsmartphone.validator.Validator

class FragmentRegister: BaseFragment() {
    lateinit var binding: FragmentRegisterBinding
    override val showBottomNavigationView = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.registerButton.setOnClickListener {
            validateRegister()
        }
        return binding.root
    }

    private fun validateRegister() {
        val emailInputLayout = binding.inputLayoutEmail
        val passwordInputLayout = binding.inputLayoutPassword
        val confirmPasswordInputLayout = binding.inputLayoutConfirmPassword
        val username = binding.inputLayoutName
        val validator = Validator(requireContext())

        username.error = validator.validateUsername(binding.editTextName)
        emailInputLayout.error = validator.validateLogin(binding.editTextEmail)
        passwordInputLayout.error = validator.validatePassword(binding.editTextPassword)
        confirmPasswordInputLayout.error = validator.confirmPassword(
            binding.editTextPassword,
            binding.editTextConfirmPassword
        )

        if (emailInputLayout.error == null
            && passwordInputLayout.error == null
            && confirmPasswordInputLayout.error == null
        ) {
            signIn()
        }
    }
    private fun signIn() {

                findNavController().navigate(R.id.action_fragmentRegister_to_fragmentRegisterOk)

    }
}