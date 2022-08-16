package com.example.openchallenge.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    private lateinit var _binding: VB
    abstract fun bindingInflater(): VB
    protected val binding :VB
        get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater()
        setContentView(_binding.root)
    }


}