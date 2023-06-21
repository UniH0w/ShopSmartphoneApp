package com.example.shopsmartphone.presentation.search.fragment.xiaomiProduct.child

import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.product.Product
import com.example.shopsmartphone.databinding.ProductItemBinding
import com.squareup.picasso.Picasso

class XiaomiChildViewHolder(private val binding: ProductItemBinding
) : RecyclerView.ViewHolder(binding.root) {
 fun bind(product: Product, itemClick: (Int) -> Unit,onItemLongClick: (Int) -> Unit)
 {
     binding.textViewName.text = product.manufacturer
     binding.textViewPrice.text = product.price
     binding.texViewModel.text =product.model
     Picasso.get().load(product.image).into(binding.imageViewProduct)
     binding.imageButtonOrder.setOnClickListener {
         itemClick.invoke(product.id.toInt())
     }
     binding.imageButtonFavorite.setOnClickListener {
         onItemLongClick.invoke(product.id.toInt())
     }

 }
}