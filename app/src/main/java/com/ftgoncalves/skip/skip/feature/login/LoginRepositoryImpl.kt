package com.ftgoncalves.skip.skip.feature.login

class LoginRepositoryImpl constructor(
    private val loginApi: LoginApi
): LoginRepository {

  override fun signIn(credential: Credential) = loginApi.signIn(credential)
}
