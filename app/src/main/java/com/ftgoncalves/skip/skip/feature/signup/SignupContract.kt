package com.ftgoncalves.skip.skip.feature.signup

import io.reactivex.Observable

object SignupContract {
  interface View {
    fun signUp(): Observable<Signup>
  }

  interface Presenter {
    fun onCreate()
    fun onDestroy()
  }
}
