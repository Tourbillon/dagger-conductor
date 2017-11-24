package com.anbillon.dagger.sample.di.components

import com.anbillon.dagger.conductor.ConductorInjectionModule
import com.anbillon.dagger.sample.SampleApplication
import com.anbillon.dagger.sample.di.modules.AppModule
import com.anbillon.dagger.sample.di.modules.ControllerModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author Vincent Cheung (coolingfall@gmail.com)
 */
@Singleton @Component(
    modules = arrayOf(ConductorInjectionModule::class, ControllerModule::class, AppModule::class))
interface AppComponent {
  fun inject(application: SampleApplication)
}