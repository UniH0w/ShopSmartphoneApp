package com.example.shopsmartphone.presentation.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shopsmartphone.R
import com.example.shopsmartphone.presentation.base.BaseFragment
import com.example.shopsmartphone.databinding.FragmentChangeAccountBinding
import com.example.shopsmartphone.databinding.FragmentChangeYourPasswordBinding


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
        return binding.root
    }
}