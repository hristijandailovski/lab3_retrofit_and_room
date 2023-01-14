package com.hfad.lab3_retrofit_and_room.model

import com.hfad.lab3_retrofit_and_room.model.Movie

interface LocalMovieDataSource {
    suspend fun insert(movie:Movie)

    suspend fun saveAll(movies:List<Movie>)

    suspend fun delete(id:String)
    suspend fun findById(id:String):Movie?

    suspend fun getAll():List<Movie>

    suspend fun searchMovies(query:String):List<Movie>
}