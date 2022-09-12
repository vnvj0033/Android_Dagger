package com.example.android.dagger.sandbox.user

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(subcomponents = [UserComponent::class])
class UserModule {

    @Provides
    @Named("id")
    fun id() = "idiii"

    @Provides
    @Named("password")
    fun password() = "pass pass"

    @Provides
    fun providesUser(
        @Named("id") id: String,
        @Named("password") password: String
    ) = Users(id, password)
}