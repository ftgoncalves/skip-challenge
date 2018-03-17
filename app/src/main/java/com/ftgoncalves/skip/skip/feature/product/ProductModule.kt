package com.ftgoncalves.skip.skip.feature.product

import com.ftgoncalves.skip.skip.di.ActivityScoped
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
@ActivityScoped
class ProductModule {

  @Provides
  fun provideProductActivity(activity: ProductActivity): ProductContract.View = activity

  @Provides
  fun providesProductPresenter(
      view: ProductContract.View,
      productRepository: ProductRepository): ProductContract.Presenter {
    return ProductPresenter(view, productRepository)
  }

  @Provides
  fun providesProductRepository(productApi: ProductApi): ProductRepository {
    return ProductRepository(productApi)
  }

  @Provides
  fun provideProductApi(retrofit: Retrofit): ProductApi {
    return retrofit.create(ProductApi::class.java)
  }
}
