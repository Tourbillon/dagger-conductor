/*
 * Copyright (C) 2017 Tourbillon Group (anbillonteam@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.anbillon.dagger.conductor;

import com.bluelinelabs.conductor.Controller;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.Multibinds;
import java.util.Map;

/**
 * Contains bindings to ensure the usability of Conductor framework classes.
 * This module should be installed in the component that is used to inject the
 * {@link android.app.Application} class.
 */
@Module public abstract class ConductorInjectionModule {
  private ConductorInjectionModule() {
    /* no instance */
  }

  @Multibinds
  abstract Map<Class<? extends Controller>, AndroidInjector.Factory<? extends Controller>> controllerInjectorFactories();
}
