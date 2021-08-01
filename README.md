# Android-MVVM-Test-App

Simple Android app purely based on **MVVM** architecture recommended by **Google** for Android applications. 
This App uses android architecture components from jetpack to demonstrate MVVM in action.

## Project Screens Preview

![Project Screens](https://www.linkpicture.com/q/Screenshot-2020-11-29-at-5.15.41-PM_1.png)

## Thoughts on architecture

As mentioned above, MVVM is the architecture that suits well for any kind & level of Android applications, there are a lot of support
libraries from jetpack that work well especially in the context of MVVM.

Single Activity and multiple fragments with the use of **Navigation** library makes is super easy to pass data along and do the fragment
transactions. And that is what **Google** promotes to use while developing Android Applications.

MVVM stands on the below-mentioned principles:
* Separation of concerns.
* Model should drive the UI.
* Assign one data source to be the single source of truth.
* Persist Data to avoid wasting network resources.
* Layered architecture for testable Units.


![Image of MVVM Architecture](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)



## Libraries Used

* [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android to perfrom Network Requests.
* [Databinding](https://developer.android.com/topic/libraries/data-binding/) - Declaratively bind data to UI elements directly within XMLs.
* [LifeCycles](https://developer.android.com/topic/libraries/architecture/lifecycle) - Helps in creating a UI that is android components lifecycle aware.
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Helps in updating views when underlying Data changes using the observer pattern.
* [Navigation](https://developer.android.com/guide/navigation) - Easy to use navigation component for in-app navigation logic.
* [Room](https://developer.android.com/topic/libraries/architecture/room) - Wrapper on top of SQLite Database with compile-time checks capabilities.
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Holds asynchronous operations data and UI related data to withstand the configuration changes due to its scope.
* [Kotlin-Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - Helps in writing the code to perform asynchronous operations.
* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Newly introduced library on top of Dagger two for [Depencency Inversion](https://developer.android.com/training/dependency-injection)
* [Espresso](https://developer.android.com/training/testing/espresso) - Library that helps to write concise, beautiful, and reliable Android UI tests.
* [Timber](https://github.com/JakeWharton/timber) - A logger library with a small, extensible API which provides utility on top of Android's normal Log class.

## App Folder Structure

```
app/
|- data/
   |- entities
   |- local
   |- remote
   |- repository
|- di/
|- ui/
|- utils/
-MainApplication
```

#### - Folder Structure Explained

1. **Data** - This folder will hold all the data related classes in it. This data can either be from a local store or from remote storage.
1. **Entities** - This folder will have all the Entities of the app as the DB models.
1. **Local** - This folder will have all the related classes for Local DB.
1. **remote** - This folder will have all the related classes for Remote data source and remote service that will fetch the data.
1. **repository** - This folder will have all the repositories of different Screens in a specific app. A class one level below the ViewModels to delegate the data fetching work.
1. **di** - This folder will have Dependency Injection related Classes.
1. **ui** - UI will hold all the UI app components like Activities and Fragments.
1. **utils** - A space for utilities that will be used by all over the application.

## Inspiration "For Commit Messages Format"
Maintaining code and tracing the specific feature or a fix for the reference purpose becomes a hard thing even after using **Git** due to poorly
written commit messages. Just to keep thing tidy I prefer to use the following format: [Scemantice Commit Messages](https://gist.github.com/joshbuchea/6f47e86d2510bce28f8e7f42ae84c716).

## Author
* Muhammad waris
* Mobile Application Developer
* Portfolio: [Muhammad waris](http://warisdgk.com/)
