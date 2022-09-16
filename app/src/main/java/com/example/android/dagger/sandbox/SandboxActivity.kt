package com.example.android.dagger.sandbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.android.dagger.R
import com.example.android.dagger.sandbox.log.LogFragment
import com.example.android.dagger.sandbox.setting.SettingFragment
import com.example.android.dagger.sandbox.user.UserFragment

class SandboxActivity: AppCompatActivity() {

    lateinit var userFragment: UserFragment
    lateinit var logFragment: LogFragment
    lateinit var settingFragment: SettingFragment

    override fun onCreate(savedInstanceState: Bundle?) {

        val appComponent = (applicationContext as App).appComponent


        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_enter_details)

        appComponent.userComponent().create(this).inject(userFragment)
        appComponent.logComponent().create(this).inject(logFragment)
        appComponent.settingComponent().create().inject(settingFragment)

        userFragment.show()
        logFragment.show()
        settingFragment.show()
    }

    private fun Fragment.show() {
        supportFragmentManager.beginTransaction().replace(R.id.container, this).commit()
    }
}