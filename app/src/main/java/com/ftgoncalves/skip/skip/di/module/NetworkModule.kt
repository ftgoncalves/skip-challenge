package com.ftgoncalves.skip.skip.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@Singleton
class NetworkModule {

  @Provides
  fun provideRetrofit() = buildRetrofit()
      .baseUrl("http://api-vanhack-event-sp.azurewebsites.net/")
      .build()

  private fun buildRetrofit(): Retrofit.Builder {
    fun getOkHttpClient(): OkHttpClient {
      return OkHttpClient.Builder().apply {
        addInterceptor(HttpLoggingInterceptor().apply {
          level = HttpLoggingInterceptor.Level.BODY
        })
      }.build()
    }

    return Retrofit.Builder()
        .client(getOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
  }
}
