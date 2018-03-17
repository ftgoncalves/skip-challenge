package com.ftgoncalves.skip.skip.feature.signup

import com.ftgoncalves.skip.skip.data.infra.UserPreference
import com.ftgoncalves.skip.skip.extension.plusAssign
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class SignupPresenter constructor(
    private val view: SignupContract.View,
    private val repository: SignupRepository,
    private val userPreference: UserPreference
) : SignupContract.Presenter {

  private val compositeDisposable = CompositeDisposable()

  override fun onCreate() {
    compositeDisposable += view.signUp()
        .flatMapSingle { repository.signUp(it) }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ userPreference.saveToken(it) }, { })
  }

  override fun onDestroy() {
    compositeDisposable.clear()
  }
}
