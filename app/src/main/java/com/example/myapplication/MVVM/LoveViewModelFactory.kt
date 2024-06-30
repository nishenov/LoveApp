package com.example.myapplication.MVVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.models.LoveApiService

class LoveViewModelFactory(private val api: LoveApiService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoveViewModel::class.java)) {
            return LoveViewModel(api) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
