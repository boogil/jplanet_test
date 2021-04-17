package com.gilly.jplanettest.presentation.adapter

import android.widget.ImageView
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gilly.jplanettest.core.extension.toPx
import com.gilly.jplanettest.data.CellType
import com.gilly.jplanettest.data.Commercial
import com.gilly.jplanettest.data.Company
import com.gilly.jplanettest.data.Theme

@BindingAdapter(value = ["cellTypes", "onCompanyClickListener"])
fun setCompanyAdapter(view: RecyclerView,
                      cellTypes: ArrayList<CellType>?,
                      onCompanyClickListener: ((Company) -> Unit)? = null) {
    cellTypes?.let {
        view.adapter?.run {
            if (this is CellTypeAdapter) {
                this.cellTypes = it
                this.notifyDataSetChanged()
            }
        } ?: run {
            CellTypeAdapter(it, onCompanyClickListener).apply {
                view.addItemDecoration(DividerItemDecoration(view.context, LinearLayout.VERTICAL))
                view.adapter = this
            }
        }
    }
}

@BindingAdapter(value = ["themes"])
fun setCommertialThemeAdapter(view: RecyclerView, themes: ArrayList<Theme>?) {
    themes?.let {
        view.adapter?.run {
            if (this is CommercialThemeAdapter) {
                this.themes = it
                this.notifyDataSetChanged()
            }
        } ?: run {
            CommercialThemeAdapter(it).apply {
                view.addItemDecoration(CustomDecoration(15.toPx(), 40.toPx(), 1))
                view.adapter = this
            }
        }
    }
}

@BindingAdapter(value = ["imgUrl"])
fun setImageUrl(view: ImageView, imgUrl: String?) {
    imgUrl?.let {
        Glide.with(view)
            .load(imgUrl)
            .into(view)
    }
}