package com.ftgoncalves.skip.skip

import com.ftgoncalves.skip.skip.di.component.ApplicationComponent
import com.ftgoncalves.skip.skip.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class SkipApplication: DaggerApplication() {
  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    applicationComponent = DaggerApplicationComponent.builder()
        .application(this)
        .build()

    applicationComponent.inject(this)

    return applicationComponent
  }

  override fun onCreate() {
    super.onCreate()

    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }

  companion object {
    lateinit var applicationComponent: ApplicationComponent
  }
}