package com.anbillon.dagger.sample

import android.util.Log
import com.bluelinelabs.conductor.Controller

/**
 * @author Vincent Cheung (coolingfall@gmail.com)
 */
class Foo(private val controoler: Controller) {
  fun log() {
    Log.d("Foo", "Controller log: " + controoler)
  }
}