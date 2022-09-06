package com.example.android.dagger.sandbox

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@CoffeeMakerScope
@Component(modules = [CoffeeMakerModule::class])
interface CoffeeComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoffeeComponent
    }

    fun inject(activity: SandboxActivity)
}