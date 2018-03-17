package com.ftgoncalves.skip.skip.feature.login

import com.ftgoncalves.skip.skip.data.infra.UserPreference
import com.ftgoncalves.skip.skip.infra.SchedulersComposer
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class LoginPresenterTest {

  @Mock
  lateinit var view: LoginContract.View

  @Mock
  lateinit var loginRepository: LoginRepository

  @Mock
  lateinit var userPreference: UserPreference

  @Mock
  lateinit var schedulersComposer: SchedulersComposer

  @InjectMocks
  lateinit var loginPresenterImpl: LoginPresenterImpl

  val testScheduler = TestScheduler()

  @Before
  fun setup() {
    `when`(schedulersComposer.mainThreadScheduler()).thenReturn(testScheduler)
  }

  @Test
  fun shouldSaveTheTokenAndNavigateToProductListView() {
    val token = "token"

    val fakeCredential = getFakeCredential()
    `when`(view.login()).thenReturn(Observable.fromCallable { fakeCredential })
    `when`(loginRepository.signIn(fakeCredential)).thenReturn(Single.fromCallable { token })
    `when`(view.signUp()).thenReturn(Observable.empty())

    loginPresenterImpl.onCreate()

    testScheduler.triggerActions()

    verify(userPreference).saveToken(token)
    verify(view).navigateToProduct()
    verify(view, never()).error()
  }

  @Test
  fun shouldNavigateToSignUp() {
    `when`(view.login()).thenReturn(Observable.empty())
    `when`(view.signUp()).thenReturn(Observable.just(Unit))

    loginPresenterImpl.onCreate()

    testScheduler.triggerActions()

    verify(view).navigateToSignUp()
  }
}

fun getFakeCredential() = Credential("email@email.com", "123")
