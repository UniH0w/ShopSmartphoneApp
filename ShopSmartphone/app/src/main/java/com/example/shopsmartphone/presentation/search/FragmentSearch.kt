package com.example.shopsmartphone.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shopsmartphone.R
import com.example.shopsmartphone.presentation.base.BaseFragment
import com.example.shopsmartphone.databinding.FragmentSearchBinding

class FragmentSearch: BaseFragment() {
    override val showBottomNavigationView = true
    private lateinit var binding: FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        binding.imageButtonGiveApple.setOnClickListener {
            findNavController()
                .navigate(R.id.action_fragmentSearch2_to_productChildFragment)
        }
        return binding.root
    }
}