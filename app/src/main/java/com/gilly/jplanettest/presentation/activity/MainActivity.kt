package com.gilly.jplanettest.presentation.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.gilly.jplanettest.R
import com.gilly.jplanettest.core.extension.observe
import com.gilly.jplanettest.databinding.ActivityMainBinding
import com.gilly.jplanettest.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BindingActivity<ActivityMainBinding>() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.cellTypes = mainViewModel.items.value

        observe(mainViewModel.items) { list ->
            list?.let { binding.progress.visibility = View.GONE }
        }

        mainViewModel.getData()
    }
}