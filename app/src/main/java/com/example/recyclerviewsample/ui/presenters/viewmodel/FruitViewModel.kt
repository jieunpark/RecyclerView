package com.example.recyclerviewsample.ui.presenters.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewsample.data.model.Fruit
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FruitViewModel @Inject constructor(): ViewModel() {

    private val _liveFruits = MutableLiveData<List<Fruit>>()
    val liveFruits: LiveData<List<Fruit>> get() = _liveFruits

    init {
        _liveFruits.value = listOf(
            Fruit(name = "Apple1"),
            Fruit(name = "Apple2"),
            Fruit(name = "Apple3"),
            Fruit(name = "Apple4"),
            Fruit(name = "Apple5"),
        )
    }


}