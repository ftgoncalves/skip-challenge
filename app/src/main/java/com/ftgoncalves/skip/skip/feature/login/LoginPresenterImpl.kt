package com.ftgoncalves.skip.skip.feature.login

import com.ftgoncalves.skip.skip.data.infra.UserPreference
import com.ftgoncalves.skip.skip.extension.plusAssign
import com.ftgoncalves.skip.skip.infra.SchedulersComposer
import io.reactivex.disposables.CompositeDisposable

class LoginPresenterImpl constructor(
    private val view: LoginContract.View,
    private val repository: LoginRepository,
    private val userPreference: UserPreference,
    private val schedulersComposer: SchedulersComposer
) : LoginContract.Presenter {

  private val compositeDisposable = CompositeDisposable()

  override fun onCreate() {
    compositeDisposable += view.login()
        .observeOn(schedulersComposer.mainThreadScheduler())
        .flatMapSingle { repository.signIn(it) }
        .doOnNext { userPreference.saveToken(it) }
        .subscribe({ view.navigateToProduct() }, { view.error() })

    compositeDisposable += view.signUp()
        .doOnNext { view.navigateToSignUp() }
        .subscribe()
  }

  override fun onDestroy() {
    compositeDisposable.clear()
  }
}
