package com.example.recyclerviewsample.common

import androidx.recyclerview.selection.ItemKeyProvider
import androidx.recyclerview.widget.RecyclerView

/**
 * Select된 ViewHolder의 ID 값을 가져옴
 */
class SelectionItemKeyProvider(private val recyclerView: RecyclerView) : ItemKeyProvider<Long>(SCOPE_MAPPED) {

    override fun getKey(position: Int): Long? {
        return recyclerView.adapter?.getItemId(position)
    }

    override fun getPosition(key: Long): Int {
        val holder = recyclerView.findViewHolderForItemId(key)
        return holder?.layoutPosition ?: RecyclerView.NO_POSITION
    }
}