package com.example.android.dagger.sandbox

import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module
class CoffeeMakerModule {

    @CoffeeMakerScope
    @Provides
    fun provideHeater(): Heater = A_Heater()

    @Provides
    fun providePump(heater: Heater) : Pump = A_Pump(heater)

    @Provides
    fun provideCoffeeMaker(heater: Heater, pump: Pump): CoffeeMaker = CoffeeMaker(heater, pump)
}


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class CoffeeMakerScope