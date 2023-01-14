package com.hfad.lab3_retrofit_and_room.repository

import com.hfad.lab3_retrofit_and_room.model.Movie
import com.hfad.lab3_retrofit_and_room.model.RemoteMovieDataSource

class MovieRepository(private val remoteMovieDataSource: RemoteMovieDataSource){

    suspend fun queryMovies(query:String):List<Movie>{
        return remoteMovieDataSource.search(query)
    }
}