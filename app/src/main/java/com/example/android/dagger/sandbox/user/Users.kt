package com.example.android.dagger.sandbox.user

import javax.inject.Inject

data class Users @Inject constructor(
    private val id: String
)
