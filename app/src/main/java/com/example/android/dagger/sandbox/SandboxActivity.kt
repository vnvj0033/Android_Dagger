package com.example.android.dagger.sandbox

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.android.dagger.R
import com.example.android.dagger.sandbox.log.LogFragment
import com.example.android.dagger.sandbox.setting.SettingFragment
import com.example.android.dagger.sandbox.user.UserFragment
import javax.inject.Inject

class SandboxActivity: AppCompatActivity() {

    @Inject lateinit var userFragment: UserFragment
    @Inject lateinit var logFragment: LogFragment
    @Inject lateinit var settingFragment: SettingFragment

    override fun onCreate(savedInstanceState: Bundle?) {

        val appComponent = (applicationContext as App).appComponent
        appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_enter_details)

        Log.d("testsyyoo", appComponent.userManager().getUsers().toString())

        userFragment.show()
        logFragment.show()
        settingFragment.show()
    }

    private fun Fragment.show() {
        supportFragmentManager.beginTransaction().replace(R.id.container, this).commit()
    }
}