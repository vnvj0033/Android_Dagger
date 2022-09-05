package com.example.android.dagger.sandbox

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoffeeMakerModule {

    @Singleton
    @Provides
    fun provideHeater(): Heater = A_Heater()

    @Provides
    fun providePump(heater: Heater) : Pump = A_Pump(heater)

    @Provides
    fun provideCoffeeMaker(heater: Heater, pump: Pump): CoffeeMaker = CoffeeMaker(heater, pump)
}