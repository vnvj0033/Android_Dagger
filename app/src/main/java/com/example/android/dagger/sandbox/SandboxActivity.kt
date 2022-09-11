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

        super.onCreate(savedInstanceState)

        Log.d("testsyyoo", (model.getString() == string).toString())
    }
}