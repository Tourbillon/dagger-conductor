package com.anbillon.dagger.sample.di.modules

import com.anbillon.dagger.sample.Foo
import com.bluelinelabs.conductor.Controller
import dagger.Module
import dagger.Provides

/**
 * @author Vincent Cheung (coolingfall@gmail.com)
 */
@Module class FooModule(private val controller: Controller) {
  @Provides fun foo(): Foo = Foo(controller)
}