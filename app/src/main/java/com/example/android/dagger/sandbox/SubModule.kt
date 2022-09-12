package com.example.android.dagger.sandbox

import com.example.android.dagger.sandbox.log.LogComponent
import com.example.android.dagger.sandbox.user.UserComponent
import dagger.Module

@Module(subcomponents = [UserComponent::class, LogComponent::class])
class SubModule
