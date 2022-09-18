package com.example.android.dagger.sandbox.user

import javax.inject.Inject

class UserManager @Inject constructor(private val users: Users) {

    fun getUsers() = users
}