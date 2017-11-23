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
import dagger.android.AndroidInjector;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Injects core Conductor types.
 */
public final class ConductorInjection {
  /**
   * Injects {@code controller} if an associated {@link AndroidInjector} implementation can be
   * found,
   * otherwise throws an {@link IllegalArgumentException}.
   *
   * <p>Uses the following algorithm to find the appropriate {@code AndroidInjector<Controller>} to
   * use to inject {@code controller}:
   *
   * <ol>
   * <li>Walks the parent-controller hierarchy to find the a controller that implements {@link
   * HasControllerInjector}, and if none do
   * <li>Uses the {@code controller}'s {@link Controller#getActivity() activity} if it implements
   * {@link HasControllerInjector}, and if not
   * <li>Uses the {@link android.app.Application} if it implements {@link HasControllerInjector}.
   * </ol>
   *
   * If none of them implement {@link HasControllerInjector}, a {@link IllegalArgumentException} is
   * thrown.
   *
   * @throws IllegalArgumentException if no parent controller, activity, or application implements
   * {@link HasControllerInjector}.
   */
  public static void inject(Controller controller) {
    checkNotNull(controller, "controller");
    HasControllerInjector hasControllerInjector = findHasControllerInjector(controller);
    AndroidInjector<Controller> controllerInjector = hasControllerInjector.controllerInjector();
    checkNotNull(controllerInjector, "%s.controllerInjector() returned null",
        hasControllerInjector.getClass().getCanonicalName());

    controllerInjector.inject(controller);
  }

  private static HasControllerInjector findHasControllerInjector(Controller controller) {
    Controller parentController = controller.getParentController();

    while (parentController != null) {
      if (parentController instanceof HasControllerInjector) {
        return (HasControllerInjector) controller;
      }
      parentController = parentController.getParentController();
    }

    if (controller.getActivity().getApplication() instanceof HasControllerInjector) {
      return (HasControllerInjector) controller.getActivity().getApplication();
    }

    throw new IllegalArgumentException(
        String.format("No injector was found for %s", controller.getClass().getCanonicalName()));
  }
}
