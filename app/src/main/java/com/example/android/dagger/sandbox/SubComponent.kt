package com.example.android.dagger.sandbox

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent
interface SubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): SubComponent
    }

    fun inject(activity: SandboxActivity)
}

@Subcomponent
interface Sub2Component {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): Sub2Component
    }

    fun inject(activity: SandboxActivity)
}