package com.example.recyclerviewsample.common

import androidx.recyclerview.selection.SelectionTracker

class SelectionObserver (
    private val selectionTracker: SelectionTracker<Long>,
    private val onSelectionChangedListener: (Int) -> Unit
) : SelectionTracker.SelectionObserver<Long>() {

    override fun onSelectionChanged() {
        super.onSelectionChanged()
        onSelectionChangedListener(selectionTracker.selection?.size() ?: 0)
    }
}