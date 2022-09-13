package com.example.android.dagger.sandbox.log

import dagger.Module
import dagger.Provides

@Module
class LogModule {

    @Provides
    fun providesLogTitle() = "log_title"

    @Provides
    fun providesLog(title: String) = Log(title)

}