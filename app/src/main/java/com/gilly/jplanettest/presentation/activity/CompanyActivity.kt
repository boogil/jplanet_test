package com.gilly.jplanettest.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.gilly.jplanettest.R
import com.gilly.jplanettest.data.Company
import com.gilly.jplanettest.databinding.ActivityCompanyBinding

class CompanyActivity : BindingActivity<ActivityCompanyBinding>() {
    override fun getLayoutResId(): Int = R.layout.activity_company

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val _company = intent.getSerializableExtra(INTENT_PARAM_COMPANY) as Company
        binding.company = _company
    }

    companion object {
        private const val INTENT_PARAM_COMPANY = "INTENT_PARAM_COMPANY"

        fun getIntent(context: Context, company: Company): Intent {
            return Intent(context, CompanyActivity::class.java).apply {
                putExtra(INTENT_PARAM_COMPANY, company)
            }
        }
    }
}