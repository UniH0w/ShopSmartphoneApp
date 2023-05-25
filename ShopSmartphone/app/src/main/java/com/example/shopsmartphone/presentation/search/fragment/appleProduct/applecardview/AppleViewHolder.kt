package com.example.shopsmartphone.presentation.search.fragment.appleProduct.applecardview

import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.product.Product
import com.example.shopsmartphone.databinding.FragmentCardViewItemBinding

class AppleViewHolder(private val binding: FragmentCardViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(product: Product, itemClick: (Int) -> Unit)
    {
        binding.textViewNameProduct.text = product.manufacturer
        binding.textViewPrice.text = product.price
        binding.textViewDescription.text =product.description
        binding.buyButtonFavorite.setOnClickListener {
            itemClick.invoke(product.id.toInt())
        }
    }
}