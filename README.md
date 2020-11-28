# Android-MVVM-Test-App

Simple Android app purely based on **MVVM** architecture recommended by **Google** for Android applications. 
This App uses android architectire components from jetpack to demonstrate MVVM in action.

## Thoughts on architecture

As mentioned above, MVVM is the architecture that suits well for any kind & level of Android applications, there are alot of support
libraries from jetpack that work well especially in context of MVVM.

Single Activity and multiple fragments and also with use of **Navigation** library makes is super easy to pass data along and do the fragment
transations. 

MVVM stands on the below mentioned principles:
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

1. **Data** - This folder will hold all the data related classes in it. This data can either be from Local store or from remote storage.
1. **Entities** - This folder will have all the Entities of app as the DB models .
1. **Local** - This folder will have all the related classes for Local DB.
1. **remote** - This folder will have all the related classes for Remote data source and remote service that will fetch the data
1. **repository** - This folder will have all the repsitories of different Screens in a specific app. A class one level below the ViewModels to delegate the data fetching work
1. **di** - This folder will have Dependency Injection related Classes
1. **ui** - UI will hold all the UI app components like Activities and Fragments
1. **utils** - A space for utilities that will be used by all over the application

## Commit Messages Format Inspiration
For maitaing code and tracing the specific feature or a fix for the reference purpose becomes a hard thing even after using **Git** due to poorly
written commit messages. Just to keep thing tidy I prefer to use the following format: [Scemantice Commit Messages](https://gist.github.com/joshbuchea/6f47e86d2510bce28f8e7f42ae84c716)

## Author
* Muhammad waris
* Mobile Application Develper
* Portfolio: [Muhammad waris](http://warisdgk.com/)
