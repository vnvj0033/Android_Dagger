package com.example.android.dagger.sandbox

import android.content.Context
import com.example.android.dagger.sandbox.log.LogComponent
import com.example.android.dagger.sandbox.log.LogFragment
import com.example.android.dagger.sandbox.setting.SettingComponent
import com.example.android.dagger.sandbox.setting.SettingFragment
import com.example.android.dagger.sandbox.user.UserComponent
import com.example.android.dagger.sandbox.user.UserFragment
import dagger.BindsInstance
import dagger.Component
import dagger.Provides

@Component(modules = [SubModule::class, FragmentModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun userComponent() : UserComponent.Factory
    fun logComponent() : LogComponent.Factory
    fun settingComponent(): SettingComponent.Factory
}