package com.example.android.dagger.sandbox.user

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.dagger.sandbox.App
import javax.inject.Inject

class UserFragment @Inject constructor() : Fragment() {

    @Inject lateinit var users: Users

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val appComponent = (requireContext().applicationContext as App).appComponent

        appComponent.userComponent().create(requireContext()).inject(this)

        return View(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("testsyyoo", users.toString())
    }
}