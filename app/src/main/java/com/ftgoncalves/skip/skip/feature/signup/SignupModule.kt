package com.ftgoncalves.skip.skip.feature.signup

import com.ftgoncalves.skip.skip.data.infra.UserPreference
import com.ftgoncalves.skip.skip.di.ActivityScoped
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
@ActivityScoped
class SignupModule {

  @Provides
  fun provideSignupActivity(activity: SignupActivity): SignupContract.View = activity

  @Provides
  fun providesSignupPresenter(
      view: SignupContract.View,
      signupRepository: SignupRepository,
      userPreference: UserPreference): SignupContract.Presenter {
    return SignupPresenter(view, signupRepository, userPreference)
  }

  @Provides
  fun providesSignupRepository(signupApi: SignupApi): SignupRepository {
    return SignupRepository(signupApi)
  }

  @Provides
  fun provideSignApi(retrofit: Retrofit): SignupApi {
    return retrofit.create(SignupApi::class.java)
  }
}
