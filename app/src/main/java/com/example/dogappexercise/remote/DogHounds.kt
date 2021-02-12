package com.example.dogappexercise.remote

import com.google.gson.annotations.SerializedName

data class DogHounds(
                    @SerializedName("message")
                    val mesagge : List<String>)
