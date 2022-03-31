package com.example.recyclerviewsample.ui.presenters.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewsample.data.model.Fruit
import com.example.recyclerviewsample.databinding.ItemFruitBinding
import com.example.recyclerviewsample.ui.presenters.bindingadapter.BaseViewHolder

class FruitAdapter(): RecyclerView.Adapter<BaseViewHolder<Fruit>>() {

    var fruits: List<Fruit> = emptyList()

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
        holder.bind(position, fruits[position])
    }

    inner class FruitViewHolder(_binding: ItemFruitBinding): BaseViewHolder<Fruit>(_binding) {
        private val binding = _binding
        override fun bind(position: Int, item: Fruit) {
            binding.fruit = item
        }
    }
}