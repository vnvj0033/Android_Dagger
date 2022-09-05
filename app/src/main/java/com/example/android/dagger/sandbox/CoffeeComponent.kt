package com.example.android.dagger.sandbox

import dagger.Component

@CoffeeMakerScope
@Component(modules = [CoffeeMakerModule::class])
interface CoffeeComponent {
    fun inject(activity: SandboxActivity)
}