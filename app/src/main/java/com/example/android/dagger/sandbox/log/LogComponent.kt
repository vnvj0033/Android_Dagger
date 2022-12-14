package com.example.android.dagger.sandbox.log

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [LogModule::class])
interface LogComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): LogComponent
    }

    fun inject(logFragment: LogFragment)

}
