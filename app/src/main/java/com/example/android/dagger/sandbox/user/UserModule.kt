package com.example.android.dagger.sandbox.user

import dagger.Module
import dagger.Provides

@Module(subcomponents = [UserComponent::class])
class UserModule {

    @Provides
    fun providesUser(id: String, password: String) = Users(id, password)
}