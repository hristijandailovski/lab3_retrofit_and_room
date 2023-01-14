package com.hfad.lab3_retrofit_and_room.ui.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hfad.lab3_retrofit_and_room.repository.MovieRepository
import com.hfad.lab3_retrofit_and_room.retrofit.MovieDbApiProvider
import com.hfad.lab3_retrofit_and_room.retrofit.RetrofitMovieDataSource
import com.hfad.lab3_retrofit_and_room.room.AppDatabase
import com.hfad.lab3_retrofit_and_room.room.RoomMovieDataSource
import com.hfad.lab3_retrofit_and_room.utils.NetworkConnectivity

class MovieFoundByIdViewModelFactory(private val context:Context):ViewModelProvider.Factory {
    override  fun<T:ViewModel> create(modelClass:Class<T>): T{
        return modelClass.getConstructor(MovieRepository::class.java)
            .newInstance(
                MovieRepository(
                    RetrofitMovieDataSource(MovieDbApiProvider.getMovieDbApi()),
                    RoomMovieDataSource(AppDatabase.getDatabase(context).movieDao()),
                    NetworkConnectivity(context)
                )
            )
    }
}