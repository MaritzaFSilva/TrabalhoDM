package com.todo.trabfinalfeltros.adapters

import com.todo.trabfinalfeltros.R
import com.todo.trabfinalfeltros.model.Material
import com.todo.trabfinalfeltros.model.Product
import kotlinx.android.synthetic.main.item_material.view.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MaterialAdapter(val product: Product) : RecyclerView.Adapter<MaterialAdapter.ViewHolder>() {
    private val materials
        get() = product.materials

    override fun getItemViewType(position: Int) = R.layout.item_material

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(viewType, parent, false)
        )

    override fun getItemCount() = materials.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val material = materials[position]
        holder.fillView(material)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun fillView(material: Material) {
            itemView.lbMaterialName.text = material.name
        }
    }
}