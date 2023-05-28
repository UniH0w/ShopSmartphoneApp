package com.example.shopsmartphone.presentation.search.fragment.accessoriesProduct.accessoriesCardView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.data.preferencesManager.PreferencesStorage
import com.example.data.storage.ApiService
import com.example.domain.models.product.BasketResponse
import com.example.domain.models.product.Product
import com.example.shopsmartphone.R
import com.example.shopsmartphone.presentation.base.BaseFragment
import com.example.shopsmartphone.databinding.FragmentAccessoriesBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection

class FragmentAccessories : BaseFragment() {
    private lateinit var binding: FragmentAccessoriesBinding
    lateinit var adapter: FragmentAccessoriesAdapter
    override val showBottomNavigationView = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val preferencesStorage = PreferencesStorage(requireContext())
        binding = FragmentAccessoriesBinding.inflate(inflater,container,false)
        binding.imageButton2.setOnClickListener {
            findNavController()
                .navigate(R.id.action_fragmentAccessories_to_accessoriesChildFragment)
        }
        getTasks(preferencesStorage)
        adapter = FragmentAccessoriesAdapter()
        binding.recyclerViewCardView.adapter = adapter
        adapter.itemClick = {
            CreateBasket()
        }

     return binding.root
    }
    private fun CreateBasket(){
        val id = arguments?.getString("id")
        val preferencesStorage =PreferencesStorage(requireContext())
        val email = preferencesStorage.readEmailPreference()
        ApiService.retrofit.basketCreate(idProduct = id.toString(), BasketResponse(
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
    private fun getTasks(preferencesStorage: PreferencesStorage) {
        val id = arguments?.getString("id")
        //binding.textView19.text = id1
        // id = id.toString()
        ApiService.retrofit.getProductCardView(id = id.toString(),"Bearer ${preferencesStorage.readLoginPreference()}").enqueue(
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

