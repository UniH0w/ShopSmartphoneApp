package com.example.shopsmartphone.presentation.search.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopsmartphone.R
import com.example.shopsmartphone.presentation.base.BaseFragment
import com.example.shopsmartphone.databinding.FragmentAccessoriesBinding

class FragmentAccessories : BaseFragment() {
    private lateinit var binding: FragmentAccessoriesBinding
    override val showBottomNavigationView = true
    private lateinit var  recyclerView: RecyclerView
    private lateinit var  searchView: SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    }
