package com.ftgoncalves.skip.skip.feature.order

import com.ftgoncalves.skip.skip.feature.product.Product

class OrderPresenter constructor(
    private val view: OrderContract.View
) : OrderContract.Presenter {

  override fun onCreate(products: List<Product>) {
    view.addProducts(products)
  }

  override fun onDestroy() {

  }
}
