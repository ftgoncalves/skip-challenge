package com.ftgoncalves.skip.skip.feature.product

import com.ftgoncalves.skip.skip.extension.plusAssign
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class ProductPresenter(
    private val view: ProductContract.View,
    private val repository: ProductRepository
) : ProductContract.Presenter {
  private val cart: MutableList<Product> = mutableListOf()

  private val compositeDisposable = CompositeDisposable()

  override fun onCreate() {
    compositeDisposable += repository.getAllProducts()
        .observeOn(AndroidSchedulers.mainThread())
        .doOnSuccess { view.addProducts(it) }
        .subscribe()

    compositeDisposable += view.productStream()
        .doOnNext { cart.add(it) }
        .doOnNext { view.updateCartItemsBadge(cart.size) }
        .subscribe()
  }

  override fun onDestroy() {
    compositeDisposable.clear()
  }

  override fun callOrder() {
    view.navigateToOrder(ArrayList(cart))
  }
}
