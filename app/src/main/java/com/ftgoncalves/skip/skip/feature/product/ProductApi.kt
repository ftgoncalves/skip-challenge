package com.ftgoncalves.skip.skip.feature.product

import io.reactivex.Single
import retrofit2.http.GET

interface ProductApi {
  @GET("api/v1/Product")
  fun getAllProducts(): Single<List<Product>>
}
