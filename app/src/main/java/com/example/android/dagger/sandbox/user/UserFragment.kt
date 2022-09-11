package com.example.android.dagger.sandbox.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.android.dagger.sandbox.SandboxActivity
import javax.inject.Inject

class UserFragment: Fragment() {

    @Inject lateinit var user: Users

    override fun onCreate(savedInstanceState: Bundle?) {
        val module = SandboxActivity.appComponent.subcomponentModule().create(requireContext())
        module.inject(this)

        super.onCreate(savedInstanceState)

    }
}