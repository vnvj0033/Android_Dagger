package com.example.android.dagger.sandbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class SandboxActivity: AppCompatActivity() {
    @Inject
    lateinit var coffeeMaker: CoffeeMaker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerCoffeeComponent.factory().create(this).inject(this)

        coffeeMaker.brew()
    }
}