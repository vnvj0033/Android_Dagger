package com.example.android.dagger.sandbox.log

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.dagger.sandbox.App
import javax.inject.Inject

class LogFragment @Inject constructor() : Fragment() {

    @Inject lateinit var log: Log

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val appComponent = (requireContext().applicationContext as App).appComponent
        appComponent.logComponent().create(requireContext()).inject(this)

        return View(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        android.util.Log.d("testsyyoo", log.toString())
    }

}
