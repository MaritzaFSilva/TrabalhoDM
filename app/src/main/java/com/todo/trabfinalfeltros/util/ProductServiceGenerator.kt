package com.todo.trabfinalfeltros.util

import com.todo.trabfinalfeltros.api.ProductService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductServiceGenerator {
    companion object {
        private var retrofit: Retrofit? = null
        private var service: ProductService? = null

        fun getService(): ProductService {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:3000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                service = retrofit!!.create(ProductService::class.java)
            }
            return service!!
        }
    }
}