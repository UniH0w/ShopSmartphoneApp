package com.example.shopsmartphone.presentation.basket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.data.preferencesManager.PreferencesStorage
import com.example.data.storage.ApiService
import com.example.domain.models.product.Product
import com.example.shopsmartphone.R
import com.example.shopsmartphone.presentation.base.BaseFragment
import com.example.shopsmartphone.databinding.FragmentBasketBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection

class FragmentBasket: BaseFragment() {
    override val showBottomNavigationView = true
    private lateinit var binding: FragmentBasketBinding
    private lateinit var adapter: AdapterFragmentBasket
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val preferencesStorage = PreferencesStorage(requireContext())
        adapter = AdapterFragmentBasket()
        binding = FragmentBasketBinding.inflate(inflater,container,false)
        binding.recyclerViewProduct.adapter =adapter
        getBasket(preferencesStorage)
        binding.orderTask.setOnClickListener {
        findNavController()
            .navigate(R.id.action_fragmentBasket2_to_fragmentOrder)
        ApiService.retrofit.basketRemoveAll("Bearer ${preferencesStorage.readLoginPreference()}")
            .enqueue(
                object : Callback<Product> {
                    override fun onResponse(call: Call<Product>, response: Response<Product>) {

                        when (response.code()) {
                            HttpURLConnection.HTTP_OK -> {
                            }

                            HttpURLConnection.HTTP_BAD_REQUEST -> Toast.makeText(
                                activity,
                                "Проблемы при оформление заказа",
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

        adapter.itemClick = { id->

            ApiService.retrofit.basketRemove(id.toString(), "Bearer ${preferencesStorage.readLoginPreference()}")
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
        return binding.root
    }


    private fun getBasket(preferencesStorage: PreferencesStorage) {
        val id = arguments?.getString("id")
        //binding.textView19.text = id1
        // id = id.toString()
        ApiService.retrofit.basketGet( "Bearer ${preferencesStorage.readLoginPreference()}").enqueue(
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