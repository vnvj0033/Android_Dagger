package com.example.android.dagger.sandbox

import com.example.android.dagger.sandbox.log.LogFragment
import com.example.android.dagger.sandbox.setting.SettingFragment
import com.example.android.dagger.sandbox.user.UserFragment
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {

    @Provides
    fun bindUserFragment() =  UserFragment()

    @Provides
    fun bindSettingFragment()= SettingFragment()

    @Provides
    fun bindLogFragment() = LogFragment()
}
