
## Sandbox Separation fragment
sandbox - Fragment 별로 Component 분리

AppComponent (modules = SubComponentModule, FragmentModule)
- userComponent() : UserComponent.Factory
- logComponent() : LogComponent.Factory
- settingComponent(): SettingComponent.Factory 
- inject(sandboxActivity: SandboxActivity)

FragmentModule
- providesUserFragment() =  UserFragment()

SubComponentModule (subcomponents = UserComponent, LogComponent, SettingComponent)

UserComponent (modules = UserModule)

UserModule
- providesUser(id: String) = Users(id)




## Qualifiers
같은 타입의 provides를 구별
````kotlin
@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class RegistrationStorage

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class LoginStorage

@Module
class StorageModule {

    @RegistrationStorage
    @Provides
    fun provideRegistrationStorage(context: Context): Storage {
        return SharedPreferencesStorage("registration", context)
    }

    @LoginStorage
    @Provides
    fun provideLoginStorage(context: Context): Storage {
        return SharedPreferencesStorage("login", context)
    }
}

// use in a method
class ClassDependingOnStorage(@RegistrationStorage private val storage: Storage) 

// use as an injected field
class ClassDependingOnStorage {

    @Inject
    @field:RegistrationStorage lateinit var storage: Storage
}
````

## Dagger end to end test
Application에 영향이 있는 테스트는 Fake객체를 사용 
````kotlin
@Module
abstract class TestStorageModule {

    // Makes Dagger provide FakeStorage when a Storage type is requested
    @Binds
    abstract fun provideStorage(storage: FakeStorage): Storage
}

class FakeStorage @Inject constructor(): Storage { ... }


@Singleton
@Component(modules = [TestStorageModule::class, AppSubcomponents::class])
interface TestAppComponent : AppComponent

// app/build.gradle
dependencies {
    kaptAndroidTest "com.google.dagger:dagger-compiler:$dagger_version"
}
````

## use custom Application in test
계측 테스트 Application을 지정
````kotlin
// class in com.example.android.dagger.MyCustomTestRunner
class MyCustomTestRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, name: String?, context: Context?): Application {
        return super.newApplication(cl, MyTestApplication::class.java.name, context)
    }
}

// app/build.gradle
android {
    defaultConfig {
        testInstrumentationRunner "com.example.android.dagger.MyCustomTestRunner"
    }
}
````

## Dagger unit test
Dagger을 직접 호출할 필요 없이 mock을 사용
````kotlin

private lateinit var viewModel: LoginViewModel
private lateinit var userManager: UserManager
private lateinit var userComponentFactory: UserComponent.Factory
private lateinit var userComponent: UserComponent

@Before
fun setup() {
    userManager = mock(UserManager::class.java)
    viewModel = LoginViewModel(userManager)
    
    userComponentFactory = Mockito.mock(UserComponent.Factory::class.java)
    userComponent = Mockito.mock(UserComponent::class.java)
    `when`(userComponentFactory.create()).thenReturn(userComponent)
}

@Test
fun `Get username`() {
    `when`(userManager.username).thenReturn("Username")

    val username = viewModel.getUsername()

    assertEquals("Username", username)
}
````

## Subcomponent
Component <- Module <- Subcomponent <- Module
Subcomponent를 사용해 Component의 Module을 분리
Component에서 제공하는 Subcomponent가 아닌 Module의 provides나 binds를 모두 공유
````kotlin
@Subcomponent // 필요시 모듈 제공 가능 @Subcomponent(module = [subModule::class])
interface RegistrationComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): RegistrationComponent
    }

    fun inject(activity: RegistrationActivity)
}

@Module(subcomponents = [RegistrationComponent::class])
class AppSubcomponents
    
@Singleton
@Component(modules = [StorageModule::class, AppSubcomponents::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
    
    fun registrationComponent(): RegistrationComponent.Factory
}
````

## custome scope
커스텀 어노테이션으로 객체 싱글턴 scope 분리 가능
````kotlin
// make custom scope
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class CustomScope

@CustomScope
@Component(modules = [StorageModule::class])
interface AppComponent { ... }

@CustomScope
class UserManager @Inject constructor(private val storage: Storage) { ... }
````

## Using scope
Conponent에서 제공하는 객체를 싱글턴으로 제공 
````kotlin
@Singleton
@Component(modules = [StorageModule::class])
interface AppComponent { ... }

@Singleton
class UserManager @Inject constructor(private val storage: Storage) { ... }

````

## Injecting the graph into an Activity
````kotlin
@Component(modules = [StorageModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)
}

// in Application
val appComponent: AppComponent by lazy {
    DaggerAppComponent.factory().create(applicationContext)
}

// in Activity

@Inject lateinit var registrationViewModel: RegistrationViewModel

override fun onCreate(savedInstanceState: Bundle?) {
    (application as MyApplication).appComponent.inject(this)
    super.onCreate(savedInstanceState)
    ...
}
````

## Component.Factory annotation
필요한 매개변수를 바인딩하여 create한다. 
````kotlin
@Component(modules = [StorageModule::class])
interface AppComponent {
    
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}

// use in Application
DaggerAppComponent.factory().create(applicationContext)
````

## BindsInstance annotation
해당 매개변수가 필요함을 알림
보통 context주입에 사용
```kotlin
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context: Context): Builder

        fun build(): AppComponent
    }
}

// use to
DaggerAppComponent.builder()
    .application(context)
    .build()
```

## Binds annotation
추상함수에 가능 Dagger의 구현임을 알림 (코드량 감소 이득)
매개변수와 반환 타입이 핵심
```kotlin
@Module
abstract class StorageModule {
    
    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorage): Storage
}

```

## Module annotation
Module 은 @Provides와 @Binds를 사용해 주입 인스턴스를 알림 
```kotlin
@Module
abstract class StorageModule
```


## Component annotation
Component는 interface or abstract로 구현
객체 주입의 컴포넘트가 됨
```kotlin
@Component
interface AppComponent {
    // Classes that can be injected by this Component
    fun inject(activity: RegistrationActivity)
}
```

## Inject annotation
주입 대상 객체에 Inject를 사용해 주입 대상 알림
```kotlin
// ViewModel in registration
class RegistrationViewModel @Inject constructor(val userManager: UserManager)

// in RegistrationActivity
@Inject lateinit var registrationViewModel: RegistrationViewModel
```

# Using Dagger in your Android app

This folder contains the source code for the "Using Dagger in your Android app" codelab.
https://developer.android.com/codelabs/android-dagger

The codelab is built in multiple GitHub branches:
* `main` is the codelab's starting point.
* `1_registration_main`, `2_subcomponents`, and `3_dagger_app` are intermediate
steps towards the solution.
* `solution` contains the solution to this codelab.


# Introduction
Dependency injection is a technique widely used in programming and well suited
to Android development. By following the principles of dependency injection, you
lay the groundwork for a good app architecture.

Implementing dependency injection provides you with the following advantages:
* Reusability of code.
* Ease of refactoring.
* Ease of testing.


# Pre-requisites
* Experience with Kotlin syntax.
* You understand Dependency Injection and know what the benefits
of using Dagger in your Android app are.

# Getting Started
1. Install Android Studio, if you don't already have it.
2. Download the sample.
3. Import the sample into Android Studio.
4. Build and run the sample.


# Comparison between different branches
* Step 1 - `main` to `1_registration_main` ([Comparison](https://github.com/googlecodelabs/android-dagger/compare/main...1_registration_main))
* Step 2 - `1_registration_main` to `2_subcomponents` ([Comparison](https://github.com/googlecodelabs/android-dagger/compare/1_registration_main...2_subcomponents))
* Step 3 - `2_subcomponents` to `3_dagger_app` ([Comparison](https://github.com/googlecodelabs/android-dagger/compare/2_subcomponents...3_dagger_app))
* Step 4 - `3_dagger_app` to `solution` ([Comparison](https://github.com/googlecodelabs/android-dagger/compare/3_dagger_app...solution))
* [Full codelab comparison](https://github.com/googlecodelabs/android-dagger/compare/main...solution)


# License

```
Copyright 2019 Google LLC

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
