package com.ftgoncalves.skip.skip.di.module

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InfraModule {

  @Provides
  @Singleton
  fun providesSharedPreference(context: Context): SharedPreferences {
    return context.getSharedPreferences("Skip", Context.MODE_PRIVATE)
  }
}