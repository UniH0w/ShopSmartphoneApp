package com.example.shopsmartphone.presentation.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shopsmartphone.R
import com.example.shopsmartphone.presentation.base.BaseFragment
import com.example.shopsmartphone.databinding.FragmentFavoritesBinding

class FragmentFavorite: BaseFragment() {
    override val showBottomNavigationView = true
    private lateinit var binding: FragmentFavoritesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater,container,false)
        binding.buyButtonFavorite.setOnClickListener {
            findNavController()
                .navigate(R.id.action_favoriteGraph_to_searchGraph)
        }
        return binding.root
    }
}