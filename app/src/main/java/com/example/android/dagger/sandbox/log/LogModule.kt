package com.example.android.dagger.sandbox.log

import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

@LogScope
@Module
class LogModule {

    @Provides
    fun providesLogTitle() = "log_title"

    @Provides
    fun providesLog(title: String) = Log(title)


}



@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class LogScope