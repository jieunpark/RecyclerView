package com.example.recyclerviewsample.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.recyclerviewsample.R
import com.example.recyclerviewsample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener{

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.listener = this@MainActivity
    }

    override fun onClick(v: View?) {
        with(binding) {
            when(v) {
                btnRecyclerView -> {
                    startActivity(
                        Intent(this@MainActivity, FruitActivity::class.java)
                    )
                }
            }
        }
    }
}