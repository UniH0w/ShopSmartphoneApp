package com.example.shopsmartphone.presentation.basket

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.product.CartItem
import com.example.domain.models.product.Product
import com.example.shopsmartphone.databinding.BasketItemBinding


class AdapterFragmentBasket: RecyclerView.Adapter<ViewHolderBasket>() {
    val items = mutableListOf<Product>()
    var itemClick: (Int) -> Unit = {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderBasket {
        return ViewHolderBasket(
            BasketItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    //@RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolderBasket, position: Int) {
        holder.bind(items[position], itemClick)
    }
    fun removeItem(CartId: String) {
        val position = items.indexOfFirst { it.id == CartId }
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    /*fun addItem(cartItem: CartItem, quantity: Int){
        val existingItem = items.find { it.id == cartItem.product.id }
        if (existingItem == null) {
            cartItem.quantity++
            cart.add(cartItem)
        } else {
            items.add(Pair(item, quantity))
        }
    }*/

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(product: List<Product>) {
        items.clear()
        items.addAll(product)
        notifyDataSetChanged()
    }
}
