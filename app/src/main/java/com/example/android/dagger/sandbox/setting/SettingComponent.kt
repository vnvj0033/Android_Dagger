package com.example.android.dagger.sandbox.setting

import com.example.android.dagger.sandbox.SandboxActivity
import dagger.Subcomponent
import javax.inject.Qualifier

@Subcomponent(modules = [SettingModule::class])
interface SettingComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SettingComponent
    }

    fun inject(activity: SandboxActivity)
    fun inject(fragment: SettingFragment)
}

