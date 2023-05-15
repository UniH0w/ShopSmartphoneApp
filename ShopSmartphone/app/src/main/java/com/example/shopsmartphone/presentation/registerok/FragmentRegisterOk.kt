package com.example.shopsmartphone.presentation.registerok

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shopsmartphone.R
import com.example.shopsmartphone.presentation.base.BaseFragment
import com.example.shopsmartphone.databinding.FragmentRegisterOkBinding

class FragmentRegisterOk: BaseFragment() {
   private lateinit var binding: FragmentRegisterOkBinding
    override val showBottomNavigationView = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterOkBinding.inflate(inflater,container,false)
        binding.continueButton.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentRegisterOk_to_fragmentLogin)
        }
        return binding.root
    }
}