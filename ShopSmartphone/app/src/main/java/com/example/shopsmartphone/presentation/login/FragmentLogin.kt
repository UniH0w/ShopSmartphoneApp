package com.example.shopsmartphone.presentation.login


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shopsmartphone.R
import com.example.shopsmartphone.presentation.base.BaseFragment
import com.example.shopsmartphone.databinding.FragmentLoginBinding
import com.example.shopsmartphone.validator.Validator

class FragmentLogin: BaseFragment() {

    lateinit var binding: FragmentLoginBinding
    override val showBottomNavigationView = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.signInButton.setOnClickListener{
           validateLogin()
        }
        binding.forgotPassword.setOnClickListener{
            findNavController()
                .navigate(R.id.action_fragmentLogin_to_fragmentForgotPassword)
        }
        binding.continueButton.setOnClickListener {
            findNavController()
                .navigate(R.id.action_fragmentLogin_to_fragmentRegister)
        }
        return binding.root
        }


    private fun validateLogin() {
        val emailInputLayout = binding.inputLayoutEmailLogin
        val passwordInputLayout = binding.inputLayoutPasswordLogin
        val validator = Validator(requireContext())
        emailInputLayout.error = validator.validateLogin(binding.editTextEmailLogin)
        passwordInputLayout.error = validator.validatePassword(binding.editTextPasswordLogin)

        if (emailInputLayout.error == null && passwordInputLayout.error == null
        ) {
            signInUser()
        }
    }
    private fun signInUser() {
                    findNavController()
                        .navigate(R.id.action_fragmentLogin_to_search_graph)
                }

}

