package com.example.android.dagger.sandbox

import android.app.Application

class App : Application() {
    val appComponent = DaggerAppComponent.factory().create(this)
}