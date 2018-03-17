package com.ftgoncalves.skip.skip.di.component

import android.app.Application
import com.ftgoncalves.skip.skip.SkipApplication
import com.ftgoncalves.skip.skip.di.module.ActivityBuilderModule
import com.ftgoncalves.skip.skip.di.module.ApplicationModule
import com.ftgoncalves.skip.skip.di.module.InfraModule
import com.ftgoncalves.skip.skip.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        NetworkModule::class,
        InfraModule::class,
        ActivityBuilderModule::class))
interface ApplicationComponent : AndroidInjector<SkipApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }
}
