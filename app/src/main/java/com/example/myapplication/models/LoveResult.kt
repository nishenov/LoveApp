package com.example.myapplication.models

import com.google.gson.annotations.SerializedName

class LoveResult (
    @SerializedName("fname")
    val fname: String,
    @SerializedName("sname")
    val sname: String,
    val percentage: String,
    val result: String,
)