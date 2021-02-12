package com.example.dogappexercise.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BreedsAPI {
    @GET("breeds/list")
    suspend fun fetchBreedsDataCoroutines() : Response<List<DogBreeds>>

    @GET("breed/{breed}/images")
    suspend fun fetchHoundsDataCoroutines(@Path("breed") breed : String)
    : Response<List<DogHounds>>

}