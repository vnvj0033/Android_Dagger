package com.example.android.dagger.sandbox.user

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [UserModule::class])
interface UserComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): UserComponent
    }

    fun inject(userFragment: UserFragment)

    fun userManager() : UserManager
}