package com.example.android.dagger.sandbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class SandboxActivity: AppCompatActivity() {


    @Inject
    lateinit var heater: Heater

    @Inject
    lateinit var pump: Pump

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerCoffeeComponent.create().inject(this)
        val coffeeMaker = CoffeeMaker(heater, pump)
        coffeeMaker.brew()
    }
}