package com.ftgoncalves.skip.skip.feature.login

import io.reactivex.Observable

object LoginContract {
  interface View {
    fun login(): Observable<Credential>
    fun signUp(): Observable<Unit>
    fun navigateToSignUp()
    fun error()
    fun navigateToProduct()
  }

  interface Presenter {
    fun onCreate()
    fun onDestroy()
  }
}