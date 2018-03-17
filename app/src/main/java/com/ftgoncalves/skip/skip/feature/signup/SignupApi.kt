package com.ftgoncalves.skip.skip.feature.signup

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface SignupApi {
  @POST("api/v1/Customer")
  fun signUp(@Body signup: Signup): Single<String>
}