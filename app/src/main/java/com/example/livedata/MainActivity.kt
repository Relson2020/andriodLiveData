package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var liveDataReference : LiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        liveDataReference = ViewModelProvider(this).get(LiveData::class.java)

        liveDataReference.liveData.observe(this,{
          binding.textView = it
        })

        binding.buttonId.setOnClickListener{
            val editText = binding.editTextId.text.toString()
            liveDataReference.dataChange(editText)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val text = binding.textView
        outState.putString("textView",text)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val textRestoreValue =savedInstanceState.getString("textView")
        binding.textView = textRestoreValue
    }
}