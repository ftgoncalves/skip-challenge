package com.ftgoncalves.skip.skip.di.module


import com.ftgoncalves.skip.skip.di.ActivityScoped
import com.ftgoncalves.skip.skip.feature.login.LoginActivity
import com.ftgoncalves.skip.skip.feature.login.LoginModule
import com.ftgoncalves.skip.skip.feature.order.OrderActivity
import com.ftgoncalves.skip.skip.feature.order.OrderModule
import com.ftgoncalves.skip.skip.feature.product.ProductActivity
import com.ftgoncalves.skip.skip.feature.product.ProductModule
import com.ftgoncalves.skip.skip.feature.signup.SignupActivity
import com.ftgoncalves.skip.skip.feature.signup.SignupModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(LoginModule::class))
    internal abstract fun loginActivity(): LoginActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(SignupModule::class))
    internal abstract fun signupActivity(): SignupActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(ProductModule::class))
    internal abstract fun productActivity(): ProductActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(OrderModule::class))
    internal abstract fun OrderActivity(): OrderActivity
}
