package com.example.shopsmartphone.presentation.search.fragment.appleProduct.child

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.data.preferencesManager.PreferencesStorage
import com.example.data.storage.ApiService
import com.example.domain.models.product.BasketResponse
import com.example.domain.models.product.FavoriteResponse
import com.example.domain.models.product.Product
import com.example.shopsmartphone.R
import com.example.shopsmartphone.databinding.FragmentChildAppleBinding
import com.example.shopsmartphone.presentation.base.BaseFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection

class ProductChildFragment : BaseFragment() {
    private lateinit var binding: FragmentChildAppleBinding
    private lateinit var adapter: ProductChildAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        adapter = ProductChildAdapter()
        binding = FragmentChildAppleBinding.inflate(inflater, container, false)
        val preferencesStorage = PreferencesStorage(requireContext())
        binding.recyclerViewProduct.adapter =adapter
        getProduct(preferencesStorage)
        binding.imageButton2.setOnClickListener {
            findNavController()
                .navigate(R.id.action_productChildFragment_to_fragmentSearch2)
        }

        adapter.itemClick = {
            val  bundle = Bundle()
            bundle.putString("id",it.toString())
            findNavController()
                .navigate(R.id.action_productChildFragment_to_fragmentApple, bundle)
        }
        adapter.onItemLongClick ={ id->
            ApiService.retrofit.favoriteCreate(idFavorite = id.toString(), FavoriteResponse(
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
    private fun getProduct(preferencesStorage: PreferencesStorage) {
        ApiService.retrofit.getProduct(manufacturer = "Apple","Bearer ${preferencesStorage.readLoginPreference()}").enqueue(
            object : Callback<List<Product>> {
                override fun onResponse(
                    call: Call<List<Product>>,
                    response: Response<List<Product>>
                ) {
                    when (response.code()) {
                        HttpURLConnection.HTTP_OK -> {
                            val list = response.body()!!
                            adapter.submitList(list)
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