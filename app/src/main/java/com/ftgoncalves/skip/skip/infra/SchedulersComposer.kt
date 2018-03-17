package com.ftgoncalves.skip.skip.infra

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class SchedulersComposer @Inject constructor() {

  open fun mainThreadScheduler(): Scheduler {
    return AndroidSchedulers.mainThread()
  }
}
