package com.todo.trabfinalfeltros.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.todo.trabfinalfeltros.R
import com.todo.trabfinalfeltros.adapters.MaterialAdapter
import com.todo.trabfinalfeltros.api.results.GetMaterialsResult
import com.todo.trabfinalfeltros.model.Product
import com.todo.trabfinalfeltros.util.ProductServiceGenerator
import kotlinx.android.synthetic.main.fragment_product.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductFragment : Fragment() {
    private lateinit var product: Product

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product, container, false)

        product = arguments?.getSerializable("product") as Product
        view.lblProductName.text = product.name
        view.lblProductDescription.text = product.description
        view.lblProductPrice.text = product.price
        view.lblProductTime.text = product.time.toString()

        Picasso.get()
            .load(product.url_image)
            .into(view.imgProduct)


        loadMaterials()

        return view
    }

    private fun loadMaterials() {
        val service = ProductServiceGenerator.getService()
        service.getMaterials(product.id).enqueue(object : Callback<GetMaterialsResult> {
            override fun onFailure(call: Call<GetMaterialsResult>, t: Throwable) {}

            override fun onResponse(
                call: Call<GetMaterialsResult>,
                response: Response<GetMaterialsResult>
            ) {
                product.materials = response.body()!!.materials
                showMaterials()
            }
        })
    }

    private fun showMaterials() {
        val adapter = MaterialAdapter(product)
        val view = view as View
        view.listMaterials.layoutManager =
            LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        view.listMaterials.adapter = adapter
    }
}