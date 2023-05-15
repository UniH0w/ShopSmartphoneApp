package com.example.shopsmartphone.presentation.search.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.shopsmartphone.databinding.FragmentAppleBinding
import com.example.shopsmartphone.presentation.base.BaseFragment

class FragmentApple:BaseFragment() {
    private lateinit var binding: FragmentAppleBinding
    override val showBottomNavigationView = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAppleBinding.inflate(inflater,container,false)



        /*binding.searchViewAccessories.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                childFragmentManager.setFragmentResult("query", bundleOf("key" to query))
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                //передаем бандл, указываем чилд фрагмент, т.к. чилд - это текущий фрагмент
                //ключи без ранизци какие, главное в приемнике тоже самое указать
                childFragmentManager.setFragmentResult("query", bundleOf("key" to newText))
                return false
            }
        })*/
        /*childFragmentManager.setFragmentResultListener(OPEN_KEY, this) { _, bundle ->
            visibleItems(true)
            val product = bundle.getSerializable(OPEN_BUNDLE_KEY) as ProductModel
            with(binding) {
                imageViewProducts
                textViewNameProduct.text = product.name
                textViewPrice.text = "N${product.price}"
                Glide.with(binding.root).load(product.icon).into(imageViewProducts)

            }

        }*/
        /*.constraintParent.setOnClickListener {
            visibleItems(false)
        }
        binding.imageButton2.setOnClickListener {
            visibleItems(false)
        }*/
        return binding.root
    }

    }
