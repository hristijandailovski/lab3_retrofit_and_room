package com.hfad.lab3_retrofit_and_room.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.lab3_retrofit_and_room.model.Movie
import com.hfad.lab3_retrofit_and_room.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel(private val movieRepository: MovieRepository): ViewModel(){
    private val moviesLiveData = MutableLiveData<List<Movie>>()

    fun getMovieLiveData():LiveData<List<Movie>> = moviesLiveData

    fun search(query:String){
        viewModelScope.launch(Dispatchers.IO) {
            val movies = movieRepository.queryMovies(query)
            moviesLiveData.postValue(movies) //mora da e postvalue poradi drug thread
        }
    }

}