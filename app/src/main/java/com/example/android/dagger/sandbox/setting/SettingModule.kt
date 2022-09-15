package com.example.android.dagger.sandbox.setting

import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

@Module
class SettingModule {

    @Provides
    fun setting(factory: SettingComponent.Factory) = Setting(factory)
}