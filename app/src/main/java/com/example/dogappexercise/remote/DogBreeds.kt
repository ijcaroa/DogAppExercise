package com.example.dogappexercise.remote

import com.google.gson.annotations.SerializedName

data class DogBreeds(
                @SerializedName ("message")
                val mesagge : List<String>)
