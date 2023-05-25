package com.example.data.storage


import com.example.domain.models.user.Auth
import com.example.domain.models.product.Product
import com.example.domain.models.user.User
import com.example.domain.models.user.UserCreate
import com.example.domain.models.user.UserUpdatePassword
import com.example.domain.models.user.UserUpdateProfile
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ShopApi {

    @POST("/v1/users/login")
     fun userLogin(@Body auth: Auth):Call <User>

    @POST("/v1/users/register")
    fun userCreate(@Body userCreate: UserCreate): Call<User>

    @POST("v1/users/update")
    fun userUpdate(@Body userUpdateProfile: UserUpdateProfile,
                   @Header("Authorization") token: String): Call <User>

    @POST("v1/users/update/password")
    fun userUpdatePassword(@Body userUpdatePassword: UserUpdatePassword,
                           @Header("Authorization") token: String): Call <User>

    @GET("v1/products")
    fun getProduct(
        @Query("manufacturer") manufacturer: String,
        @Header("Authorization") token: String): Call<List<Product>>

    @GET("v1/products/id")
    fun getProductCardView(
        @Query("id") id: String,
        @Header("Authorization")  token: String): Call<List<Product>>
}