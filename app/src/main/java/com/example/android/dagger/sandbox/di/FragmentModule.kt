package com.example.android.dagger.sandbox.di

import com.example.android.dagger.sandbox.log.LogFragment
import com.example.android.dagger.sandbox.setting.SettingFragment
import com.example.android.dagger.sandbox.user.UserFragment
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {

    @Provides
    fun providesUserFragment() =  UserFragment()

    @Provides
    fun providesSettingFragment()= SettingFragment()

    @Provides
    fun providesLogFragment() = LogFragment()
}
