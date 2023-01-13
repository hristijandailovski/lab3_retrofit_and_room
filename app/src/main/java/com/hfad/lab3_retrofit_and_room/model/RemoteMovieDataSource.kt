package com.hfad.lab3_retrofit_and_room.model

interface RemoteMovieDataSource {
    suspend fun search(query:String): List<Movie>

}