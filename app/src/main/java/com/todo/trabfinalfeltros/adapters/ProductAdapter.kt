package com.todo.trabfinalfeltros.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.todo.trabfinalfeltros.R
import com.todo.trabfinalfeltros.model.Product
import com.todo.trabfinalfeltros.util.ProductServiceGenerator
import kotlinx.android.synthetic.main.fragment_product.view.*
import kotlinx.android.synthetic.main.item_product.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductAdapter(private val listener: ProductAdapterListener) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private var products = mutableListOf<Product>()
    private val service = ProductServiceGenerator.getService()

    init {
        service.getAll().enqueue(object : Callback<List<Product>> {
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {}

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                products = response.body()!!.toMutableList()
                notifyDataSetChanged()
            }
        })
    }

    override fun getItemViewType(position: Int) = R.layout.item_product

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(viewType, parent, false)
        )

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.fillView(product)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun fillView(product: Product) {
            itemView.lbProductName.text = product.name
            itemView.lbProductPrice.text = product.price






            itemView.setOnClickListener {
                listener.onProductSelected(product)
            }
        }
    }
}