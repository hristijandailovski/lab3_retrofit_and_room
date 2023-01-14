package com.hfad.lab3_retrofit_and_room.ui.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hfad.lab3_retrofit_and_room.model.Movie
import com.hfad.lab3_retrofit_and_room.repository.MovieRepository
import com.hfad.lab3_retrofit_and_room.retrofit.MovieDbApiProvider
import com.hfad.lab3_retrofit_and_room.retrofit.RetrofitMovieDataSource

class MoviesViewModelFactory(private val context: Context):ViewModelProvider.Factory {
    override  fun<T:ViewModel> create(modelClass:Class<T>): T{
        return modelClass.getConstructor(MovieRepository::class.java)
            .newInstance(MovieRepository(RetrofitMovieDataSource(MovieDbApiProvider.getMovieDbApi())))
    }
}