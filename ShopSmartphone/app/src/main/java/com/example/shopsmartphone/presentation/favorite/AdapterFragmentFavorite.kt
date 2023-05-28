package com.example.shopsmartphone.presentation.favorite

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.product.Product
import com.example.shopsmartphone.databinding.BasketItemBinding
import com.example.shopsmartphone.databinding.FavoriteItemBinding


class AdapterFragmentFavorite: RecyclerView.Adapter<ViewHolderFavorite>() {
    val items = mutableListOf<Product>()
    var itemClick: (Int) -> Unit = {
    }
    var onItemLongClick: (Int) -> Unit = {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFavorite {
        return ViewHolderFavorite(
            FavoriteItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    //@RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolderFavorite, position: Int) {
        holder.bind(items[position], itemClick, onItemLongClick)
    }
    fun removeItem(FavoriteId: String) {
        val position = items.indexOfFirst { it.id == FavoriteId }
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(product: List<Product>) {
        items.clear()
        items.addAll(product)
        notifyDataSetChanged()
    }
}
