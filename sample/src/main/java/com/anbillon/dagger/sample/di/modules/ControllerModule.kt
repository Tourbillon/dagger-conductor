package com.anbillon.dagger.sample.di.modules

import com.anbillon.dagger.conductor.ControllerKey
import com.anbillon.dagger.sample.HomeController
import com.anbillon.dagger.sample.di.components.ConductorComponent.HomeComponent
import com.bluelinelabs.conductor.Controller
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * @author Vincent Cheung (coolingfall@gmail.com)
 */
@Module(subcomponents = arrayOf(HomeComponent::class)) abstract class ControllerModule {
  @Binds @IntoMap @ControllerKey(HomeController::class) abstract fun bindHome(
      builder: HomeComponent.Builder): AndroidInjector.Factory<out Controller>

}