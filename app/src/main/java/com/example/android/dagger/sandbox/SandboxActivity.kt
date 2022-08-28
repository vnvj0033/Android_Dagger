package com.example.android.dagger.sandbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class SandboxActivity: AppCompatActivity() {

    @Inject lateinit var foo: Foo

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as SandboxApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        foo
    }
}