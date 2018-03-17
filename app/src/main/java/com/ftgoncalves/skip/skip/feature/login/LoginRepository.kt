package com.ftgoncalves.skip.skip.feature.login

import io.reactivex.Single

interface LoginRepository {
  fun signIn(credential: Credential): Single<String>
}