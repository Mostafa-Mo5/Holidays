package com.example.openchallenge

import com.example.openchallenge.databinding.ActivityMainBinding
import com.example.openchallenge.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun bindingInflater() = ActivityMainBinding.inflate(layoutInflater)
}