package com.example.recyclerviewsample.ui.presenters.bindingadapter

import android.annotation.SuppressLint
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewsample.data.model.Fruit
import com.example.recyclerviewsample.ui.presenters.adapter.FruitAdapter

object FruitBindingAdapter {

    /**
     * NFT 리스트 데이터 바인딩
     */
    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter("bindFruitList")
    @JvmStatic
    fun bindFruitList(recyclerView: RecyclerView, items: LiveData<List<Fruit>?>) {
        items.value?.let {
            (recyclerView.adapter as FruitAdapter).fruits = it
            recyclerView.adapter?.notifyDataSetChanged()
        }
    }
}