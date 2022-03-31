package com.example.recyclerviewsample.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.selection.ItemKeyProvider
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewsample.R
import com.example.recyclerviewsample.common.DetailsLookup
import com.example.recyclerviewsample.common.SelectionItemKeyProvider
import com.example.recyclerviewsample.common.SelectionObserver
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

    private lateinit var selectionTracker: SelectionTracker<Long>
    private lateinit var selectionObserver: SelectionObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = fruitViewModel
        initRecyclerView()
    }

    private fun initRecyclerView() {

        with(binding.recyclerView) {
            this.adapter = FruitAdapter()
            this.layoutManager = GridLayoutManager(this@FruitActivity, 3)

            val recyclerView = this
            selectionTracker = SelectionTracker.Builder<Long>(
                FruitActivity::javaClass.name,
                recyclerView,
                SelectionItemKeyProvider(recyclerView),
                DetailsLookup(recyclerView),
                StorageStrategy.createLongStorage()
            ).withSelectionPredicate(
                SelectionPredicates.createSelectAnything()
            ).build()
            (adapter as? FruitAdapter)?.tracker = selectionTracker

            selectionObserver = SelectionObserver(selectionTracker) { selectedCount ->
                onSelectionChanged(selectedCount)
            }
            selectionTracker.addObserver(selectionObserver)
        }
    }

    private fun onSelectionChanged(selectedCount: Int) {
        Log.w("FruitActivity", ">>> selectedCounr $selectedCount" )
    }
}