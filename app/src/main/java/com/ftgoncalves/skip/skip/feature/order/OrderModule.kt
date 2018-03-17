package com.ftgoncalves.skip.skip.feature.order

import com.ftgoncalves.skip.skip.di.ActivityScoped
import com.ftgoncalves.skip.skip.feature.product.ProductApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
@ActivityScoped
class OrderModule {

  @Provides
  fun provideOrderActivity(activity: OrderActivity): OrderContract.View = activity

  @Provides
  fun providesOrderPresenter(view: OrderContract.View): OrderContract.Presenter {
    return OrderPresenter(view)
  }

//  @Provides
//  fun providesProductRepository(productApi: ProductApi): ProductRepository {
//    return ProductRepository(productApi)
//  }

  @Provides
  fun provideProductApi(retrofit: Retrofit): ProductApi {
    return retrofit.create(ProductApi::class.java)
  }
}
