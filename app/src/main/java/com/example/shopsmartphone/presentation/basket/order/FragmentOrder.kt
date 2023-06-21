package com.example.shopsmartphone.presentation.basket.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shopsmartphone.R
import com.example.shopsmartphone.databinding.FragmentOrderBinding
import com.example.shopsmartphone.presentation.base.BaseFragment

class FragmentOrder: BaseFragment() {
    private lateinit var binding: FragmentOrderBinding
    override val showBottomNavigationView = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderBinding.inflate(inflater, container, false)

        binding.signInButton.setOnClickListener {
            findNavController()
                .navigate(R.id.action_fragmentOrder_to_fragmentBasket2)
        }
        return binding.root
    }
}