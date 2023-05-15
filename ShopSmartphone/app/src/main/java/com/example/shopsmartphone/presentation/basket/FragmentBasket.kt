package com.example.shopsmartphone.presentation.basket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shopsmartphone.R
import com.example.shopsmartphone.presentation.base.BaseFragment
import com.example.shopsmartphone.databinding.FragmentBasketBinding

class FragmentBasket: BaseFragment() {
    override val showBottomNavigationView = true
    private lateinit var binding: FragmentBasketBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBasketBinding.inflate(inflater,container,false)
        binding.buyButtonBasket.setOnClickListener {
            findNavController()
                .navigate(R.id.action_basketGraph_to_searchGraph)
        }
        return binding.root

    }
}