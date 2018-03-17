package com.ftgoncalves.skip.skip.feature.order

import com.ftgoncalves.skip.skip.feature.product.Product

object OrderContract {
  interface View {
    fun addProducts(products: List<Product>)
  }

  interface Presenter {
    fun onCreate(products: List<Product>)
    fun onDestroy()
  }
}