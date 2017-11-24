Dagger Conductor
=========
An extension of [dagger2][1] for [Conductor][2]

Usage
=====
* See [dagger2 document][3]
* Replace `HasActivityInjector` with `HasControllerInjector` in `Application` or `Activity`
* Replace `@ActivityKey` with `@ControllerKey`
* Replace `AndroidInjectionModule` with `ConductorInjectionModule` in `YourAppComponent`
* Replace `AndroidInjection.inject(this)` with `ConductorInjection.inject(this)` in `Controller`

Gradle
=======

	compile 'com.anbillon.dagger:dagger-conductor:1.0.0'


License
=======

    Copyright (C) 2017 Tourbillon Group (anbillonteam@gmail.com)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
         http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



[1]:https://github.com/google/dagger
[2]:https://github.com/bluelinelabs/Conductor
[3]:https://google.github.io/dagger/android