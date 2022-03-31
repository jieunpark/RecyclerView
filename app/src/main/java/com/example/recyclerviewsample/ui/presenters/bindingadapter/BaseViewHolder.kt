package com.example.recyclerviewsample.ui.presenters.bindingadapter

import android.content.Context
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<T>(_binding: ViewDataBinding): RecyclerView.ViewHolder(_binding.root) {
    var context: Context? = null
    open fun bind(position: Int, item: T) {}
}