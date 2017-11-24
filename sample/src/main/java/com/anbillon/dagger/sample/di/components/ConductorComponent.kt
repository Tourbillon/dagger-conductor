package com.anbillon.dagger.sample.di.components

import com.anbillon.dagger.sample.HomeController
import com.anbillon.dagger.sample.di.modules.FooModule
import com.anbillon.dagger.sample.di.scope.PerController
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * @author Vincent Cheung (coolingfall@gmail.com)
 */
object ConductorComponent {
  @PerController @Subcomponent(modules = arrayOf(FooModule::class))
  interface HomeComponent : AndroidInjector<HomeController> {
    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<HomeController>() {

      abstract fun fooModule(module: FooModule): Builder

      override fun seedInstance(controller: HomeController) {
        fooModule(FooModule(controller))
      }
    }
  }
}