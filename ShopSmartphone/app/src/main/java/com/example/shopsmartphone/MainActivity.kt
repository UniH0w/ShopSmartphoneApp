package com.example.shopsmartphone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.shopsmartphone.databinding.ActivityMainBinding
import com.example.shopsmartphone.managers.BottomNavigationViewManager

class MainActivity : AppCompatActivity(), BottomNavigationViewManager {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController =
            (supportFragmentManager.findFragmentById(R.id.containerView)
                    as NavHostFragment).navController
        binding.bNav.setupWithNavController(navController)
    }

    override fun setNavigationViewVisibility(isVisible: Boolean) {
        binding.bNav.isVisible = isVisible
    }
}