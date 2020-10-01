package com.todo.trabfinalfeltros.api



import com.todo.trabfinalfeltros.api.results.GetMaterialsResult
import com.todo.trabfinalfeltros.model.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {
    @GET("products")
    fun getAll(): Call<List<Product>>

    @GET("products/{id}")
    fun get(): Call<Product>

    @GET("materials/{productId}")
    fun getMaterials(@Path("productId") productId: Long): Call<GetMaterialsResult>
}