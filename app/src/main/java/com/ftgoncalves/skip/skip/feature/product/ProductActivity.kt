package com.ftgoncalves.skip.skip.feature.product

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.View
import android.widget.TextView
import com.ftgoncalves.skip.skip.R
import com.ftgoncalves.skip.skip.feature.order.OrderActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_product.productList
import javax.inject.Inject


class ProductActivity : DaggerAppCompatActivity(), ProductContract.View {
  @Inject
  lateinit var adapter: ProductAdapter

  @Inject
  lateinit var presenter: ProductContract.Presenter

  private lateinit var cartBadge: TextView

  private val layoutManager by lazy {
    LinearLayoutManager(this)
  }

  override fun productStream() = adapter.productClickStream()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_product)

    initView()

    presenter.onCreate()
  }

  private fun initView() {
    productList.layoutManager = layoutManager
    productList.adapter = adapter
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.product_cart, menu)

    val notification = menu.findItem(R.id.cart).actionView

    cartBadge = notification.findViewById(R.id.badge) as TextView

    notification.setOnClickListener {
      presenter.callOrder()
    }

    return true
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.onDestroy()
  }

  override fun addProducts(products: List<Product>) {
    adapter.addProducts(products)
  }

  override fun updateCartItemsBadge(size: Int) {
    cartBadge.visibility = View.VISIBLE
    cartBadge.text = size.toString()
  }

  override fun navigateToOrder(cart: ArrayList<Product>) {
    startActivity(OrderActivity.getCallingIntent(this, cart))
  }

  companion object {
    fun getCallingIntent(context: Context) = Intent(context, ProductActivity::class.java)
  }
}
