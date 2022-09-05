package com.example.android.dagger.sandbox

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoffeeMakerModule::class])
interface CoffeeComponent {
    fun inject(activity: SandboxActivity)
}