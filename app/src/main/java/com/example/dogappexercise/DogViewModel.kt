package com.example.dogappexercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogappexercise.remote.DogBreeds
import com.example.dogappexercise.remote.DogHounds
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {

    private val repository : DogRepository
    lateinit var livedataFromInternet : LiveData<List<DogBreeds>>


    init {
        repository = DogRepository()
        viewModelScope.launch {
            livedataFromInternet = repository.fetchDataFromInternetCoroutines()
        }
    }

}