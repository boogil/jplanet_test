package com.gilly.jplanettest.presentation.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.gilly.jplanettest.R
import com.gilly.jplanettest.core.exception.Failure
import com.gilly.jplanettest.core.extension.makeToast
import com.gilly.jplanettest.core.extension.observe
import com.gilly.jplanettest.databinding.ActivityMainBinding
import com.gilly.jplanettest.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(binding) {
            mainVm = mainViewModel
            onCompanyClickListener = { company ->
                startActivity(CompanyActivity.getIntent(this@MainActivity, company))
            }

            observe(mainViewModel.cellTypes) { list ->
                list?.let { progress.visibility = View.GONE }
            }
            observe(mainViewModel.failure) { failure ->
                progress.visibility = View.GONE

                when {
                    failure is Failure.ServerFailure -> R.string.toast_error_msg_server
                    failure is Failure.NetworkFailure ->  R.string.toast_error_msg_network
                    else -> R.string.toast_error_msg_etc
                }.let { msg ->
                    makeToast(msg)
                }
            }
        }

        mainViewModel.getData()
    }
}