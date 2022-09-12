package com.example.android.dagger.sandbox.log

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(subcomponents = [LogComponent::class])
class LogModule {

    @Provides
    @Named("log_title")
    fun providesLogTitle() = "log title"

    @Provides
    @Named("log_ver")
    fun providesLogVer() = "126"

    @Provides
    fun providesLog(
        @Named("log_title") title: String,
        @Named("log_ver") ver: String
    ) = Log(title, ver)
}