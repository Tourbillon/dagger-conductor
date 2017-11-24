package com.anbillon.dagger.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction

/**
 * @author Vincent Cheung (coolingfall@gmail.com)
 */
class MainActivity : AppCompatActivity() {
  @BindView(R.id.controller_container) lateinit var container: ViewGroup

  private var unbinder: Unbinder? = null
  private var router: Router? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    unbinder = ButterKnife.bind(this)
    router = Conductor.attachRouter(this, container, savedInstanceState)
    if (!router!!.hasRootController()) {
      router!!.setRoot(RouterTransaction.with(HomeController()))
    }
  }

  override fun onBackPressed() {
    if (!router!!.handleBack()) {
      super.onBackPressed()
    }
  }

  override fun onDestroy() {
    unbinder!!.unbind()
    super.onDestroy()
  }
}
