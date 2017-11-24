package com.anbillon.dagger.sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anbillon.dagger.conductor.ConductorInjection
import com.bluelinelabs.conductor.Controller
import javax.inject.Inject

/**
 * @author Vincent Cheung (coolingfall@gmail.com)
 */
class HomeController : Controller() {
  @Inject lateinit var foo: Foo
  @Inject lateinit var bar: Bar

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
    ConductorInjection.inject(this)
    return inflater.inflate(R.layout.controller_home, container, false)
  }

  override fun onAttach(view: View) {
    super.onAttach(view)
    foo.log()
    bar.log()
  }
}