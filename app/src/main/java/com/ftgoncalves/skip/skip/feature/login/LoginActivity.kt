package com.ftgoncalves.skip.skip.feature.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.ftgoncalves.skip.skip.R
import com.ftgoncalves.skip.skip.feature.product.ProductActivity
import com.ftgoncalves.skip.skip.feature.signup.SignupActivity
import com.jakewharton.rxbinding2.view.RxView
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.email
import kotlinx.android.synthetic.main.activity_main.login
import kotlinx.android.synthetic.main.activity_main.password
import kotlinx.android.synthetic.main.activity_main.sign_up
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity(), LoginContract.View {
  @Inject
  lateinit var presenter: LoginContract.Presenter

  override fun login(): Observable<Credential> = RxView.clicks(login)
      .map { Credential(email.text.toString(), password.text.toString()) }

  override fun signUp(): Observable<Unit> = RxView.clicks(sign_up).map {  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    presenter.onCreate()
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.onDestroy()
  }

  override fun navigateToSignUp() {
    startActivity(SignupActivity.getCallingIntent(this))
  }

  override fun navigateToProduct() {
    startActivity(ProductActivity.getCallingIntent(this))
  }

  override fun error() {
    Toast.makeText(this,  R.string.try_again, Toast.LENGTH_LONG).show()
  }

  companion object {
    fun getCallingIntent(context: Context) = Intent(context, LoginActivity::class.java)
  }
}
