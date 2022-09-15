package com.example.android.dagger.sandbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.android.dagger.R
import com.example.android.dagger.sandbox.log.LogFragment
import com.example.android.dagger.sandbox.setting.SettingFragment
import com.example.android.dagger.sandbox.user.UserFragment

class SandboxActivity: AppCompatActivity() {

    private val userFragment: UserFragment = UserFragment()
    private val logFragment: LogFragment = LogFragment()
    private val settingFragment: SettingFragment = SettingFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        val appComponent = DaggerAppComponent.factory().create(this)

        appComponent.userComponent().create(this).inject(userFragment)
        appComponent.logComponent().create(this).inject(logFragment)

        appComponent.settingComponent().create().inject(settingFragment)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_enter_details)

        userFragment.show()
        logFragment.show()
        settingFragment.show()
    }

    private fun Fragment.show() {
        supportFragmentManager.beginTransaction().replace(R.id.container, this).commit()
    }
}