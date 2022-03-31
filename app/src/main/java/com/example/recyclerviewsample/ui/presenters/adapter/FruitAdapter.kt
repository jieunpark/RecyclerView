package com.example.recyclerviewsample.ui.presenters.adapter

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewsample.data.model.Fruit
import com.example.recyclerviewsample.databinding.ItemFruitBinding
import com.example.recyclerviewsample.ui.presenters.bindingadapter.BaseViewHolder

class FruitAdapter(): RecyclerView.Adapter<BaseViewHolder<Fruit>>() {

    var fruits: List<Fruit> = emptyList()
    var tracker: SelectionTracker<Long>? = null

    override fun getItemCount(): Int = fruits.size
    override fun getItemId(position: Int): Long = position.toLong()

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Fruit> {
        val binding = ItemFruitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FruitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Fruit>, position: Int) {
        val isSelected = tracker?.isSelected(position.toLong()) ?: false
        holder.bind(position, fruits[position], isSelected)
    }

    inner class FruitViewHolder(_binding: ItemFruitBinding): BaseViewHolder<Fruit>(_binding) {
        private val binding = _binding
        override fun bind(position: Int, item: Fruit, isSelected: Boolean) {
            itemView.isSelected = isSelected
            binding.fruit = item
        }


        fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
            object : ItemDetailsLookup.ItemDetails<Long>() {
                override fun getPosition() = bindingAdapterPosition
                override fun getSelectionKey() = itemId
                override fun inSelectionHotspot(e: MotionEvent) = false // true 탭 한번으로 선택모드 진입
            }
    }
}