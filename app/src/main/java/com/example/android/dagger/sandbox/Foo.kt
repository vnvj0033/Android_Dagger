package com.example.android.dagger.sandbox

import android.util.Log
import javax.inject.Inject

class Foo @Inject constructor() {
    init {
        Log.d("testsyyoo", "init Foo")
    }
}
