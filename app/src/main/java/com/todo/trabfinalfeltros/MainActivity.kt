package com.todo.trabfinalfeltros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.todo.trabfinalfeltros.fragments.ProductFragment
import com.todo.trabfinalfeltros.fragments.ProductListFragment
import com.todo.trabfinalfeltros.fragments.ProductListFragmentListener
import com.todo.trabfinalfeltros.model.Product
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ProductListFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (complexLayout) {
            supportFragmentManager.beginTransaction().apply {
                val productListFragment = ProductListFragment(this@MainActivity)
                replace(R.id.productListFragmentContainer, productListFragment)
                commit()
            }
        }
    }

    override fun onProductSelected(product: Product) {
        if (complexLayout) {
            supportFragmentManager.beginTransaction().apply {
                val productFragment = ProductFragment()
                val bundle = Bundle()
                bundle.putSerializable("product", product)

                productFragment.arguments = bundle
                replace(R.id.productFragmentContainer, productFragment)
                addToBackStack(null)
                commit()
            }
        }
    }

    private val complexLayout
        get() = productFragmentContainer != null
}