package com.example.android.dagger.sandbox

import javax.inject.Inject

data class Goo @Inject constructor(
    val foo: String
)
