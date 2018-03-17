package com.ftgoncalves.skip.skip.feature.login

import com.ftgoncalves.skip.skip.data.infra.UserPreference
import com.ftgoncalves.skip.skip.di.ActivityScoped
import com.ftgoncalves.skip.skip.infra.SchedulersComposer
import dagger.Module
import dagger.Provides
import io.reactivex.Single
import retrofit2.Retrofit

@Module
@ActivityScoped
class LoginModule {

  @Provides
  fun provideLoginActivity(activity: LoginActivity): LoginContract.View = activity

  @Provides
  fun providesLoginPresenter(
      view: LoginContract.View,
      loginRepository: LoginRepository,
      userPreference: UserPreference,
      schedulersComposer: SchedulersComposer): LoginContract.Presenter {
    return LoginPresenterImpl(view, loginRepository, userPreference, schedulersComposer)
  }

  // The Endpoint of login is not working I got a advice from a employee of Skip that I should hardcode the token
  @Provides
  fun providesLoginRepository(loginApi: LoginApi): LoginRepository {
    return FakeLoginRepository()
  }

  @Provides
  fun provideUserApi(retrofit: Retrofit): LoginApi {
    return retrofit.create(LoginApi::class.java)
  }
}


class FakeLoginRepository : LoginRepository {
  override fun signIn(credential: Credential): Single<String> {
    return Single.just("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiRmVsaXBlIFRoZW9kb3JvIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvZW1haWxhZGRyZXNzIjoiZnRnb25jYWx2ZXNAZ21haWwuY29tIiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy91c2VyZGF0YSI6IjU1IiwibmJmIjoxNTIxMzA0MDAzLCJleHAiOjE1MjM3MjMyMDMsImlzcyI6InZhbmhhY2stc2FvcGF1bG8tZmFpci1hcGkiLCJhdWQiOiJ2YW5oYWNrLXNhb3BhdWxvLWZhaXItYXBpIn0.LFHX1qCXZRQE4mW8DWM4rPaN-jRqy6oI0GnCZE7ZfrU")
  }
}