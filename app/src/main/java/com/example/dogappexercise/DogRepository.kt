package com.example.dogappexercise

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dogappexercise.remote.DogBreeds
import com.example.dogappexercise.remote.DogHounds
import com.example.dogappexercise.remote.RetrofitClient

class DogRepository {
    private  val retrofitClient = RetrofitClient.getRetrofit()
    private val dataFromInternet = MutableLiveData<List<DogBreeds>>()

    suspend fun fetchDataFromInternetCoroutines()  : LiveData<List<DogBreeds>> {
        try {
            val response = retrofitClient.fetchBreedsDataCoroutines()
            when (response.code()) {
                in 200..299 -> dataFromInternet.value = response.body()
                in 300..301 -> Log.d("REPO", "${response.code()} --- ${response.errorBody()}")
                else -> Log.d("REPO", "${response.code()} --- ${response.errorBody().toString()}")
            }
        } catch (t: Throwable) {
            Log.e("REPO", "${t.message}")
        }
        return dataFromInternet
    }
}