package com.ftgoncalves.skip.skip.feature.order

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ftgoncalves.skip.skip.R
import com.ftgoncalves.skip.skip.feature.product.Product
import javax.inject.Inject

class OrderAdapter @Inject constructor() : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

  private val products: MutableList<Product> = mutableListOf()

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): OrderViewHolder {
    return OrderViewHolder(LayoutInflater.from(parent?.context)
        .inflate(R.layout.order, parent, false))
  }

  override fun getItemCount() = products.size

  override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
    val product = products.get(position)

    holder.apply {
      name.text = product.name
      description.text = product.description
    }
  }

  internal fun addProducts(products: List<Product>) {
    this.products.addAll(products)
    notifyDataSetChanged()
  }

  inner class OrderViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val name: TextView = view.findViewById(R.id.name)
    val description: TextView = view.findViewById(R.id.description)
  }
}
