package com.example.shopsmartphone.screens.ForgotPassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.shopsmartphone.presentation.base.BaseFragment
import com.example.shopsmartphone.databinding.FragmentForgotPasswordBinding

class FragmentForgotPassword: BaseFragment() {
    lateinit var binding: FragmentForgotPasswordBinding
    override val showBottomNavigationView = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgotPasswordBinding.inflate(layoutInflater)
        binding.registerButton.setOnClickListener {
         }
        return binding.root
    }
}