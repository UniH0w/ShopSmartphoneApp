package com.example.shopsmartphone.presentation.search.fragment.child

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shopsmartphone.R
import com.example.shopsmartphone.data.ProductModel
import com.example.shopsmartphone.databinding.FragmentChildAppleBinding
import com.example.shopsmartphone.presentation.base.BaseFragment

class ProductChildFragment : BaseFragment() {
    private lateinit var binding: FragmentChildAppleBinding
    private lateinit var productChildAdapter: ProductChildAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChildAppleBinding.inflate(inflater,container, false)
        productChildAdapter = ProductChildAdapter()
        val list = listOf(ProductModel(id  = 1, manufacturer = "Apple", price = "58484", description = "fdgdfsgdfgdf",  icon = "" ))
        binding.recyclerViewProduct.adapter = productChildAdapter

        productChildAdapter.submitList(list)

        productChildAdapter.itemClick = {
            findNavController()
                .navigate(R.id.action_productChildFragment_to_fragmentApple)
        }


        return binding.root
    }
}