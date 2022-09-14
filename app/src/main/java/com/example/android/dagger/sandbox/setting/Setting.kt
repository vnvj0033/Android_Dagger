package com.example.android.dagger.sandbox.setting

import javax.inject.Inject

class Setting @Inject constructor(
    val settingComponent: SettingComponent.Factory
){

    lateinit var setting: SettingComponent

    fun update() {
        setting = settingComponent.create()
    }
}
