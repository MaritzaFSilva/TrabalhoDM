package com.todo.trabfinalfeltros.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.todo.trabfinalfeltros.R
import com.todo.trabfinalfeltros.adapters.ProductAdapter
import com.todo.trabfinalfeltros.adapters.ProductAdapterListener
import com.todo.trabfinalfeltros.model.Product
import kotlinx.android.synthetic.main.fragment_product_list.*
import kotlinx.android.synthetic.main.fragment_product_list.view.*
import java.lang.Exception

class ProductListFragment(private val listener: ProductListFragmentListener? = null) : Fragment(),
    ProductAdapterListener {
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product_list, container, false)

        adapter = ProductAdapter(this)
        view.listProducts.adapter = adapter
        view.listProducts.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

        return view
    }

    override fun onProductSelected(product: Product) {
        val bundle = Bundle()
        bundle.putSerializable("product", product)
        try {
            findNavController().navigate(R.id.navigateToProductFragment, bundle)
        } catch (e: Exception) {
        }

        listener?.onProductSelected(product)
    }

}