package com.anbillon.dagger.sample

import android.app.Application
import com.anbillon.dagger.conductor.HasControllerInjector
import com.anbillon.dagger.sample.di.components.DaggerAppComponent
import com.anbillon.dagger.sample.di.modules.AppModule
import com.bluelinelabs.conductor.Controller
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

/**
 * @author Vincent Cheung (coolingfall@gmail.com)
 */
class SampleApplication : Application(), HasControllerInjector {
  @Inject lateinit var dispatchingControllerInjector: DispatchingAndroidInjector<Controller>

  override fun onCreate() {
    super.onCreate()
    DaggerAppComponent.builder().appModule(AppModule(this)).build().inject(this)
  }

  override fun controllerInjector(): AndroidInjector<Controller> = dispatchingControllerInjector
}