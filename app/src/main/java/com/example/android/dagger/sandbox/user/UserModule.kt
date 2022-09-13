package com.example.android.dagger.sandbox.user

import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @Provides
    fun id() = "user_id"

    @Provides
    fun providesUser(id: String) = Users(id)

}