package com.example.android.dagger.sandbox.user

import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

@Module
class UserModule {

    @Provides
    fun id() = "user_id"

    @Provides
    fun providesUser(id: String) = Users(id)

}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class UserScope