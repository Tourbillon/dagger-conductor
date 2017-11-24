package com.anbillon.dagger.sample.di.modules

import android.content.Context
import com.anbillon.dagger.sample.SampleApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Vincent Cheung (coolingfall@gmail.com)
 */
@Module(includes = arrayOf(BarModule::class)) class AppModule(
    private val application: SampleApplication) {
  @Provides
  @Singleton internal fun provideAppContext(): Context = application.applicationContext
}