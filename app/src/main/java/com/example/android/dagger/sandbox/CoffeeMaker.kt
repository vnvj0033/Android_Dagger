package com.example.android.dagger.sandbox

import android.util.Log

class CoffeeMaker (private val heater: Heater, private val pump: Pump) {

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
    fun isHot(): Boolean
}

interface Pump {
    fun pump()
    fun getHeater(): Heater
}

class A_Heater : Heater {
    private var heating = false
    override fun on() { heating = true }
    override fun off() { heating = false }
    override fun isHot(): Boolean = heating

}

class A_Pump(private var heater: Heater) :Pump {

    override fun pump() {
        if (heater.isHot()) {
            Log.d("A_Pump", "pimping!")
        }
    }

    override fun getHeater() = heater
}