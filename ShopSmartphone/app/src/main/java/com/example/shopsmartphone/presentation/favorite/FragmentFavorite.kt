package com.example.shopsmartphone.presentation.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.data.preferencesManager.PreferencesStorage
import com.example.data.storage.ApiService
import com.example.domain.models.product.BasketResponse
import com.example.domain.models.product.Product
import com.example.shopsmartphone.R
import com.example.shopsmartphone.presentation.base.BaseFragment
import com.example.shopsmartphone.databinding.FragmentFavoritesBinding
import com.example.shopsmartphone.presentation.basket.AdapterFragmentBasket
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection

class FragmentFavorite: BaseFragment() {
    override val showBottomNavigationView = true
    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var adapter: AdapterFragmentFavorite
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val preferencesStorage = PreferencesStorage(requireContext())
        adapter = AdapterFragmentFavorite()
        binding = FragmentFavoritesBinding.inflate(inflater,container,false)
        binding.recyclerViewProduct.adapter =adapter
        getFavorite(preferencesStorage)
        adapter.itemClick = { id->
            ApiService.retrofit.favoriteRemove(id.toString(), "Bearer ${preferencesStorage.readLoginPreference()}")
                .enqueue(
                    object : Callback<Product> {
                        override fun onResponse(call: Call<Product>, response: Response<Product>) {

                            if (response.isSuccessful) {
                                adapter.removeItem(id.toString())
                                Toast.makeText(
                                    activity,
                                    getString(R.string.task_ok_delete_request),
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                Toast.makeText(
                                    activity,
                                    getString(R.string.no_found_id_request),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        override fun onFailure(call: Call<Product>, t: Throwable) {

                            Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                )
        }

        adapter.onItemLongClick ={id->
            ApiService.retrofit.basketCreate(id.toString(), BasketResponse(
                id = id.toString()),
                "Bearer ${preferencesStorage.readLoginPreference()}").enqueue(
                object : Callback<Product> {
                    override fun onResponse(call: Call<Product>, response: Response<Product>) {

                        when (response.code()) {
                            HttpURLConnection.HTTP_OK -> {
                            }

                            HttpURLConnection.HTTP_BAD_REQUEST -> Toast.makeText(
                                activity,
                                getString(R.string.login_bad_request),
                                Toast.LENGTH_SHORT
                            ).show()

                            HttpURLConnection.HTTP_UNAUTHORIZED -> Toast.makeText(
                                activity,
                                getString(R.string.login_unauthorized),
                                Toast.LENGTH_SHORT
                            ).show()

                            else -> Toast.makeText(
                                activity,
                                getString(R.string.request_error),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<Product>, t: Throwable) {

                        Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }

        return binding.root
    }

    private fun getFavorite(preferencesStorage: PreferencesStorage) {
        ApiService.retrofit.favoriteGet( "Bearer ${preferencesStorage.readLoginPreference()}").enqueue(
            object : Callback<List<Product>> {
                override fun onResponse(
                    call: Call<List<Product>>,
                    response: Response<List<Product>>
                ) {
                    when (response.code()) {
                        HttpURLConnection.HTTP_OK -> {
                            val list = response.body()!!
                            if (list.isEmpty()) {
                                binding.favoriteNull.visibility = View.VISIBLE
                            } else {
                                binding.favoriteNull.visibility = View.INVISIBLE
                                adapter.submitList(list)
                            }
                        }
                        HttpURLConnection.HTTP_BAD_REQUEST -> Toast.makeText(
                            activity,
                            getString(R.string.task_bad_request),
                            Toast.LENGTH_SHORT
                        ).show()

                        HttpURLConnection.HTTP_UNAUTHORIZED -> Toast.makeText(
                            activity,
                            getString(R.string.missing_token_error),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                    Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()
                }
            }
        )
    }
}
