package com.example.android.dagger.sandbox.user

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class UserModule {

    @Provides
    @Named("id")
    fun id() = "user_id"

    @Provides
    @Named("password")
    fun password() = "user_password"

    @Provides
    fun providesUser(
        @Named("id") id: String,
        @Named("password") password: String
    ) = Users(id, password)

}