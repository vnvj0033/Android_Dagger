package com.example.android.dagger.sandbox.setting

import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

@Module
class SettingModule {

    @SettingScope
    @Provides
    fun setting(factory: SettingComponent.Factory) = Setting(factory)
}


@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class SettingScope