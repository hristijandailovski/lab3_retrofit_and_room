package com.hfad.lab3_retrofit_and_room.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.lab3_retrofit_and_room.model.Movie
import com.hfad.lab3_retrofit_and_room.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieFoundByIdViewModel(private val movieRepository: MovieRepository):ViewModel() {
    private val mutableMovieFoundByIdLiveData = MutableLiveData<Movie>()

    fun getMovieFoundByIdLiveData(): MutableLiveData<Movie> =mutableMovieFoundByIdLiveData

    fun searchMovieById(id:String){
        viewModelScope.launch(Dispatchers.IO){
            val movie=movieRepository.findMovieById(id)
            mutableMovieFoundByIdLiveData.postValue(movie?:Movie("null","null","null","null","null"))
        }
    }
}