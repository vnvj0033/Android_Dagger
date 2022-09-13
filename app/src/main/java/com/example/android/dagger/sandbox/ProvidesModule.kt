package com.example.android.dagger.sandbox

import com.example.android.dagger.sandbox.log.Log
import com.example.android.dagger.sandbox.user.Users
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ProvidesModule {

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
