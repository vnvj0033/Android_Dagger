package com.example.android.dagger.sandbox

import javax.inject.Inject

class Model @Inject constructor(
    private val string: String
) {
    fun getString() = string
}