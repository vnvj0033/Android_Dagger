package com.example.android.dagger.sandbox

import android.app.Application
import com.example.android.dagger.sandbox.di.DaggerAppComponent

class App : Application() {
    val appComponent = DaggerAppComponent.factory().create(this)
}