package com.example.android.dagger.sandbox

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class SandboxActivity: AppCompatActivity() {
    @Inject
    lateinit var string: String
    @Inject
    lateinit var model: Model

    override fun onCreate(savedInstanceState: Bundle?) {
        val module = DaggerMainComponent.factory().create(this).subcomponentModule().create(this)

        module.v2String()

        super.onCreate(savedInstanceState)

        Log.d("testsyyoo", (model.getString() == string).toString())
    }
}