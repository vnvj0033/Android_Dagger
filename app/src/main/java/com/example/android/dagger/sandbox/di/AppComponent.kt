package com.example.android.dagger.sandbox.di

import android.content.Context
import com.example.android.dagger.sandbox.SandboxActivity
import com.example.android.dagger.sandbox.log.LogComponent
import com.example.android.dagger.sandbox.setting.SettingComponent
import com.example.android.dagger.sandbox.user.UserComponent
import com.example.android.dagger.sandbox.user.UserManager
import dagger.BindsInstance
import dagger.Component

@Component(modules = [SubModule::class, FragmentModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun userComponent() : UserComponent.Factory
    fun logComponent() : LogComponent.Factory
    fun settingComponent(): SettingComponent.Factory

    fun users(): UserManager

    fun inject(sandboxActivity: SandboxActivity)
}