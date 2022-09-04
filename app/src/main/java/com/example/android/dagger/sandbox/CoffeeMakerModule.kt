package com.example.android.dagger.sandbox

import dagger.Module
import dagger.Provides

@Module
class CoffeeMakerModule {
    @Provides
    fun provideHeater(): Heater = A_Heater()

    @Provides
    fun providePump(heater: Heater): Pump = A_Pump(heater)
}