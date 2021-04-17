package com.gilly.jplanettest.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.gilly.jplanettest.R
import com.gilly.jplanettest.core.extension.onThrottleClick
import com.gilly.jplanettest.data.CellType
import com.gilly.jplanettest.data.Commercial
import com.gilly.jplanettest.data.Company
import com.gilly.jplanettest.data.Review
import com.gilly.jplanettest.databinding.ItemCommercialBinding
import com.gilly.jplanettest.databinding.ItemCommercialRecyclerviewBinding
import com.gilly.jplanettest.databinding.ItemCompanyBinding
import com.gilly.jplanettest.databinding.ItemReviewBinding

class CellTypeAdapter(
    var cellTypes: ArrayList<CellType>,
    private val onCompanyClickListener: ((Company) -> Unit)? = null
) : RecyclerView.Adapter<BindingViewHolder<ViewDataBinding>>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<ViewDataBinding> {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ITEM_TYPE_COMPANY -> {
                CompanyViewHolder(
                    layoutInflater.inflate(
                        R.layout.item_company,
                        parent, false
                    )
                )
            }
            ITEM_TYPE_COMMERCIAL -> {
                CommercialViewHolder(
                    layoutInflater.inflate(
                        R.layout.item_commercial_recyclerview,
                        parent,
                        false
                    )
                )
            }
            ITEM_TYPE_REVIEW -> {
                ReviewViewHolder(
                    layoutInflater.inflate(
                        R.layout.item_review,
                        parent, false
                    )
                )
            }
            else -> {
                CompanyViewHolder(
                    layoutInflater.inflate(
                        R.layout.item_company,
                        parent, false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: BindingViewHolder<ViewDataBinding>, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int = cellTypes.size

    override fun getItemViewType(position: Int): Int {
        val cellType = cellTypes.get(position)

        return when {
            cellType is Company -> ITEM_TYPE_COMPANY
            cellType is Commercial -> ITEM_TYPE_COMMERCIAL
            cellType is Review -> ITEM_TYPE_REVIEW
            else -> ITEM_TYPE_NONE
        }
    }

    inner class CompanyViewHolder(view: View) : BindingViewHolder<ItemCompanyBinding>(view) {
        override fun onCreate() {
        }

        override fun onBind(position: Int) {
            (cellTypes.get(position) as Company).let { company ->
                binding.company = company
                binding.wrapper.onThrottleClick {
                    onCompanyClickListener?.invoke(company)
                }
            }
        }
    }

    inner class CommercialViewHolder(view: View) :
        BindingViewHolder<ItemCommercialRecyclerviewBinding>(view) {
        override fun onCreate() {
        }

        override fun onBind(position: Int) {
            binding.commercial = cellTypes.get(position) as Commercial
        }
    }

    inner class ReviewViewHolder(view: View) : BindingViewHolder<ItemReviewBinding>(view) {
        override fun onCreate() {
        }

        override fun onBind(position: Int) {
            binding.review = cellTypes.get(position) as Review
        }
    }

    companion object {
        private const val ITEM_TYPE_COMPANY = 0
        private const val ITEM_TYPE_COMMERCIAL = 1
        private const val ITEM_TYPE_REVIEW = 2
        private const val ITEM_TYPE_NONE = 3
    }
}