# Android-MVVM-Test-App

Simple Android app purely based on **MVVM** architecture recommended by **Google** for Android applications. 
This App uses android architectire components from jetpack to demonstrate MVVM in action.

## Thoughts on architecture

As mentioned above, MVVM is the architecture that suits well for any kind & level of Android applications, there are alot of support
libraries from jetpack that work well especially in context of MVVM.

MVVM stands on the below mentioned principles
* Separation of concerns
* Model should drive the UI
* Assign one data source to be the Single source of truth
* Persist Data to avoid wasting network resources
* Layered architecture for testable Units 

## Libraries Used

* [Databinding](https://developer.android.com/topic/libraries/data-binding/) - Declaratively bind data to UI elements directly within XMLs.
* [LifeCycles](https://developer.android.com/topic/libraries/architecture/lifecycle) - Helps in creating a UI that is andorid components lifecycle aware.
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Helps in updating views when undelying Data changes using observer pattern.
* [Navigation](https://developer.android.com/guide/navigation) - Easy to use navigation component for in-app navigation logic.
* [Room](https://developer.android.com/topic/libraries/architecture/room) - Wrapper on top of SQLite Database with compile time checks capabilities.
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Holds asyncronous operations data and UI related data to with stand the configuration changes due to its scope.
* [Kotlin-Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - Helps in writing the code to perform asyncronous operations.
* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Newly introduced library on top of Dagger two for [Depencency Inversion](https://developer.android.com/training/dependency-injection)
