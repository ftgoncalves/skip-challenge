package com.ftgoncalves.skip.skip.feature.signup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ftgoncalves.skip.skip.R
import com.jakewharton.rxbinding2.view.RxView
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_signup.address
import kotlinx.android.synthetic.main.activity_signup.email
import kotlinx.android.synthetic.main.activity_signup.name
import kotlinx.android.synthetic.main.activity_signup.password
import kotlinx.android.synthetic.main.activity_signup.signup
import javax.inject.Inject

class SignupActivity : DaggerAppCompatActivity(), SignupContract.View {

  @Inject
  lateinit var presenter: SignupContract.Presenter

  override fun signUp(): Observable<Signup> = RxView.clicks(signup)
      .map {
        Signup(
            name.text.toString(),
            email.text.toString(),
            password.text.toString(),
            address.text.toString()
        )
      }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_signup)

    presenter.onCreate()
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.onDestroy()
  }

  companion object {
    fun getCallingIntent(context: Context) = Intent(context, SignupActivity::class.java)
  }
}
