package com.gilly.jplanettest.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.gilly.jplanettest.R
import com.gilly.jplanettest.data.*
import com.gilly.jplanettest.databinding.ItemCommercialBinding
import com.gilly.jplanettest.databinding.ItemCommercialRecyclerviewBinding
import com.gilly.jplanettest.databinding.ItemCompanyBinding
import com.gilly.jplanettest.databinding.ItemReviewBinding

class CommercialThemeAdapter(var themes: ArrayList<Theme>) :
    RecyclerView.Adapter<BindingViewHolder<ViewDataBinding>>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<ViewDataBinding> {
        return CommercialViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_commercial, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BindingViewHolder<ViewDataBinding>, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int = themes.size

    inner class CommercialViewHolder(view: View) :
        BindingViewHolder<ItemCommercialBinding>(view) {

        override fun onCreate() {
        }

        override fun onBind(position: Int) {
            binding.theme = themes.get(position)
        }
    }
}