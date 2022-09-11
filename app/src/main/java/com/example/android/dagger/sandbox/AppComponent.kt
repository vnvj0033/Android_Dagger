package com.example.android.dagger.sandbox

import android.content.Context
import com.example.android.dagger.sandbox.user.UserComponent
import com.example.android.dagger.sandbox.user.UserModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [UserModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun subcomponentModule() : UserComponent.Factory
}