package com.example.recyclerviewsample.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewsample.R
import com.example.recyclerviewsample.databinding.ActivityFruitBinding
import com.example.recyclerviewsample.databinding.ActivityMainBinding
import com.example.recyclerviewsample.ui.presenters.adapter.FruitAdapter
import com.example.recyclerviewsample.ui.presenters.viewmodel.FruitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FruitActivity : AppCompatActivity() {

    private val fruitViewModel: FruitViewModel by viewModels()
    private val binding: ActivityFruitBinding by lazy {
        DataBindingUtil.setContentView<ActivityFruitBinding?>(this@FruitActivity, R.layout.activity_fruit)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = fruitViewModel
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.adapter = FruitAdapter()
        binding.recyclerView.layoutManager = GridLayoutManager(this, 3)
    }
}