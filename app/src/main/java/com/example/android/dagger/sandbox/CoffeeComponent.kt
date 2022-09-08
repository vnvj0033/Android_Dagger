package com.example.android.dagger.sandbox

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Subcomponent

@Component(modules = [CoffeeMakerModule::class, AppSubcomponentsModule::class])
interface CoffeeComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoffeeComponent
    }

    fun inject(activity: SandboxActivity)
    fun appSubcomponentsModule() : CoffeeSubcomponent.Factory
}


@Subcomponent
interface CoffeeSubcomponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoffeeSubcomponent
    }

    fun inject(activity: SandboxActivity)
}


@Module(subcomponents = [CoffeeSubcomponent::class])
class AppSubcomponentsModule