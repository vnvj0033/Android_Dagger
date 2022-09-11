package com.example.android.dagger.sandbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SandboxActivity: AppCompatActivity() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent = DaggerAppComponent.factory().create(this)

        super.onCreate(savedInstanceState)

    }
}