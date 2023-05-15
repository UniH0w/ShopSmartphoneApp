package com.example.shopsmartphone.presentation.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shopsmartphone.extensions.navigateTo
import com.example.shopsmartphone.R
import com.example.shopsmartphone.presentation.base.BaseFragment
import com.example.shopsmartphone.databinding.FragmentSplashBinding

class FragmentSplash: BaseFragment() {
        private lateinit var binding: FragmentSplashBinding
        private val handler = Handler()
    private val runnable = Runnable { //Second fragment after 5 seconds appears
        navigateTo(R.id.action_fragmentSplash_to_fragmentLogin)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        handler.postDelayed(runnable, 3000)
        return binding.root
    }
    override fun onDestroy() {
        handler.removeCallbacks(runnable);
        super.onDestroy()
    }
    }

