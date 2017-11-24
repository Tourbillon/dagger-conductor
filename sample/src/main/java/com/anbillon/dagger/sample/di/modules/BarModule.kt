package com.anbillon.dagger.sample.di.modules

import com.anbillon.dagger.sample.Bar
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Vincent Cheung (coolingfall@gmail.com)
 */
@Module class BarModule {
  @Provides @Singleton fun bar(): Bar = Bar()
}