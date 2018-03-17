package com.ftgoncalves.skip.skip.feature.product

class ProductRepository constructor(
    private val api: ProductApi
) {
  fun getAllProducts() = api.getAllProducts()
}
