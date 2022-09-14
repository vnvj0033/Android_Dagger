package com.example.android.dagger.sandbox.setting

import com.example.android.dagger.sandbox.SandboxActivity
import dagger.Subcomponent

@Subcomponent
interface SettingComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SettingComponent
    }

    fun inject(activity: SandboxActivity)
}