package com.example.openchallenge

import android.os.Bundle
import com.example.openchallenge.databinding.ActivityMainBinding
import com.example.openchallenge.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun bindingInflater() = ActivityMainBinding.inflate(layoutInflater)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}