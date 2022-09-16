package com.example.android.dagger.sandbox

import com.example.android.dagger.sandbox.log.LogFragment
import com.example.android.dagger.sandbox.setting.SettingFragment
import com.example.android.dagger.sandbox.user.UserFragment
import dagger.Binds
import dagger.Module

@Module
abstract class FragmentModule {

    @Binds
    abstract fun bindUserFragment(): UserFragment

    @Binds
    abstract fun bindSettingFragment(): SettingFragment

    @Binds
    abstract fun bindLogFragment(): LogFragment
}
