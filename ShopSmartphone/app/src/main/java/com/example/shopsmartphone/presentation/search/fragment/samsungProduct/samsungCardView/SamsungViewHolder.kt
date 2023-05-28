package com.example.shopsmartphone.presentation.search.fragment.samsungProduct.samsungCardView

import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.product.Product
import com.example.shopsmartphone.databinding.FragmentCardViewItemBinding
import com.squareup.picasso.Picasso

class SamsungViewHolder(private val binding: FragmentCardViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(product: Product, itemClick: (Int) -> Unit)
    {
        binding.textViewNameProduct.text = product.manufacturer
        binding.textViewPrice.text = product.price
        binding.textViewDescription.text =product.description
        binding.texViewModelProduct.text = product.model
        Picasso.get().load(product.image).into(binding.imageViewProducts)
        binding.buyButtonFavorite.setOnClickListener {
            itemClick.invoke(product.id.toInt())
        }
    }
}