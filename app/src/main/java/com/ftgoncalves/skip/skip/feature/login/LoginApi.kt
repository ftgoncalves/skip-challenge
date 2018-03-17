package com.ftgoncalves.skip.skip.feature.login

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
  @POST("api/v1/Customer/auth")
  fun signIn(@Body credential: Credential): Single<String>
}