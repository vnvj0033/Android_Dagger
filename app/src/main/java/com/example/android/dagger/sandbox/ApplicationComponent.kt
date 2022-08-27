package com.example.android.dagger.sandbox

import androidx.appcompat.app.AppCompatActivity
import dagger.Component

@Component
interface ApplicationComponent {

    fun inject(activity: AppCompatActivity)

}