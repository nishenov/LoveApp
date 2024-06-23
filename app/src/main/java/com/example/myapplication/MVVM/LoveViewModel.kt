package com.example.myapplication.MVVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.models.LoveApiService
import com.example.myapplication.models.LoveResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveViewModel(private val api: LoveApiService) : ViewModel() {

    private val _loveResult = MutableLiveData<LoveResult>()
    val loveResult: LiveData<LoveResult> get() = _loveResult

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun getLovePercentage(key: String, host: String, firstName: String, secondName: String) {
        api.getPercentage(key, host, firstName, secondName)?.enqueue(object : Callback<LoveResult> {
            override fun onResponse(call: Call<LoveResult>, response: Response<LoveResult>) {
                if (response.isSuccessful && response.body() != null) {
                    _loveResult.value = response.body()
                } else {
                    _error.value = "Error: ${response.message()}"
                }
            }

            override fun onFailure(call: Call<LoveResult>, t: Throwable) {
                _error.value = t.message
            }
        })
    }
}
