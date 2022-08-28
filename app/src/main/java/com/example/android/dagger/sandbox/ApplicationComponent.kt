package com.example.android.dagger.sandbox

import dagger.Component

@Component
interface ApplicationComponent {

    fun inject(activity: SandboxActivity)
}