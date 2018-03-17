package com.ftgoncalves.skip.skip.feature.product

import io.reactivex.Observable

object ProductContract {
  interface View {
    fun addProducts(products: List<Product>)
    fun productStream(): Observable<Product>
    fun updateCartItemsBadge(size: Int)
    fun navigateToOrder(cart: ArrayList<Product>)
  }

  interface Presenter {
    fun onCreate()
    fun onDestroy()
    fun callOrder()
  }
}