package com.example.myapplication.MVP

import com.example.myapplication.models.LoveApiService
import com.example.myapplication.models.LoveResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private val view: LoveView, private val api: LoveApiService) {
    fun getLovePercentage(key: String, host: String, firstName: String, secondName: String) {
        api.getPercentage(key, host, firstName, secondName).enqueue(object : Callback<LoveResult> {
            override fun onResponse(call: Call<LoveResult>, response: Response<LoveResult>) {
                if (response.isSuccessful && response.body() != null) {
                    view.showResult(response.body()!!)
                } else {
                    view.showError("Не удалось получить данные")
                }
            }

            override fun onFailure(call: Call<LoveResult>, t: Throwable) {
                view.showError(t.message ?: "Ошибка запроса")
            }
        })
    }
}
