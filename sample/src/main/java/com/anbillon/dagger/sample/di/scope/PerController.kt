package com.anbillon.dagger.sample.di.scope

import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

/**
 * A scoping annotation to permit objects whose lifetime should conform to the life of
 * the [com.bluelinelabs.conductor.Controller] to be memorized in the correct component.
 *
 * @author Vincent Cheung (coolingfall@gmail.com)
 */
@Scope @Retention(RUNTIME) annotation class PerController
