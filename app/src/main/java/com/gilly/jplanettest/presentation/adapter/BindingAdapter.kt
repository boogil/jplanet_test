package com.gilly.jplanettest.presentation.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gilly.jplanettest.core.extension.toPx
import com.gilly.jplanettest.data.CellType
import com.gilly.jplanettest.data.Company

@BindingAdapter(value = ["cellTypes"])
fun setCompanyAdapter(view: RecyclerView, cellTypes: ArrayList<CellType>?) {
    cellTypes?.let {
        view.adapter?.run {
            if (this is CellTypeAdapter) {
                this.cellTypes = it
                this.notifyDataSetChanged()
            }
        } ?: run {
            CellTypeAdapter(it).apply {
                view.addItemDecoration(CustomDecoration(0, 8.toPx(), 1))
                view.adapter = this
            }
        }
    }
}