package com.example.recyclerviewsample.common

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewsample.ui.presenters.adapter.FruitAdapter

class DetailsLookup (
    private val recyclerView: RecyclerView
) : ItemDetailsLookup<Long>() {
    override fun getItemDetails(event: MotionEvent): ItemDetails<Long>? {
        val view = recyclerView.findChildViewUnder(event.x, event.y)
        if (view != null) {
            return (recyclerView.getChildViewHolder(view) as FruitAdapter.FruitViewHolder)
                .getItemDetails()
        }
        return null
    }
}