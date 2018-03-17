package com.ftgoncalves.skip.skip.feature.signup

class SignupRepository constructor(
    private val api: SignupApi
) {
  fun signUp(signup: Signup) = api.signUp(signup)
}
