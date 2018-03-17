package com.ftgoncalves.skip.skip.feature.order

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.ftgoncalves.skip.skip.R
import com.ftgoncalves.skip.skip.feature.product.Product
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_order.orderList
import javax.inject.Inject

class OrderActivity : DaggerAppCompatActivity(), OrderContract.View {
  @Inject
  lateinit var adapter: OrderAdapter

  @Inject
  lateinit var presenter: OrderContract.Presenter

  private val layoutManager by lazy {
    LinearLayoutManager(this)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_order)

    orderList.layoutManager = layoutManager
    orderList.adapter = adapter

    val products = intent.getParcelableArrayListExtra<Product>(PRODUCT)

    presenter.onCreate(products)
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.onDestroy()
  }

  override fun addProducts(products: List<Product>) {
    adapter.addProducts(products)
  }

  companion object {
    const val PRODUCT = "products_args"

    fun getCallingIntent(context: Context, products: ArrayList<Product>): Intent {

      val intent = Intent(context, OrderActivity::class.java)
      intent.putExtra(PRODUCT, products)

      return intent
    }
  }
}
