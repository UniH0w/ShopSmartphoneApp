package com.example.shopsmartphone.presentation.favorite

import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.product.Product
import com.example.shopsmartphone.databinding.BasketItemBinding
import com.example.shopsmartphone.databinding.FavoriteItemBinding
import com.example.shopsmartphone.databinding.FragmentXiaomiBinding
import com.squareup.picasso.Picasso

class ViewHolderFavorite(private val binding: FavoriteItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(product: Product, itemClick: (Int) -> Unit,onItemLongClick: (Int) -> Unit)
    {
        binding.textViewName.text = product.manufacturer
        binding.textViewPrice.text = product.price
        binding.texViewModel.text = product.model
        Picasso.get().load(product.image).into(binding.imageViewProduct)
        binding.imageButtonDeleteBasket.setOnClickListener {
            itemClick.invoke(product.id.toInt())
        }
        binding.imageButtonOrder.setOnClickListener {
            onItemLongClick.invoke(product.id.toInt())
        }
    }
}