package com.ftgoncalves.skip.skip.feature.product

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ftgoncalves.skip.skip.R
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class ProductAdapter @Inject constructor() : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

  private val productObservable = PublishSubject.create<Product>()

  private val products: MutableList<Product> = mutableListOf()

  fun productClickStream(): Observable<Product> = productObservable

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProductViewHolder {
    return ProductViewHolder(LayoutInflater.from(parent?.context)
        .inflate(R.layout.product, parent, false))
  }

  override fun getItemCount() = products.size

  override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
    val product = products.get(position)

    holder.apply {
      productItem = product
      name.text = product.name
      description.text = product.description
    }
  }

  internal fun addProducts(products: List<Product>) {
    this.products.addAll(products)
    notifyDataSetChanged()
  }

  inner class ProductViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val name: TextView = view.findViewById(R.id.name)
    val description: TextView = view.findViewById(R.id.description)

    var productItem: Product? = null

    init {
      view.setOnClickListener {
        productItem?.let {
          productObservable.onNext(it)
          removeItemFromList(it)
        }
      }
    }

    private fun removeItemFromList(product: Product) {
      val index = products.indexOf(product)
      products.removeAt(index)
      notifyItemRemoved(index)
    }
  }
}
