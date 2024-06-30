package com.example.myapplication.MVP

import com.example.myapplication.models.LoveResult

interface LoveView {
    fun showResult(loveResult: LoveResult)
    fun showError(message: String)
}