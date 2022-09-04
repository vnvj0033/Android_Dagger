package com.example.android.dagger.sandbox

import android.util.Log
import javax.inject.Inject

class CoffeeMaker(val heater: Heater, val pump: Pump) {

    fun brew() {
        heater.on()
        pump.pump()
        Log.d("coffeMaker", "[_]P coffee! [_]P")
        heater.off()
    }
}


interface Heater {
    fun on()
    fun off()
    fun isHeat(): Boolean
}

interface Pump {
    fun pump()
}

class A_Heater : Heater {
    private var heat = false
    override fun on() {
        heat = true
    }

    override fun off() {
        heat = false
    }

    override fun isHeat(): Boolean = heat

}

class A_Pump(private val heater: Heater) :Pump {
    override fun pump() {
        if (heater.isHeat()) {
            Log.d("A_Pump", "pimping!")
        }
    }
}