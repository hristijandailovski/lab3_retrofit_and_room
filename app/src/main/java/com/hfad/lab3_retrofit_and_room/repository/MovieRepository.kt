package com.hfad.lab3_retrofit_and_room.repository

import com.hfad.lab3_retrofit_and_room.model.LocalMovieDataSource
import com.hfad.lab3_retrofit_and_room.model.Movie
import com.hfad.lab3_retrofit_and_room.model.RemoteMovieDataSource
import com.hfad.lab3_retrofit_and_room.utils.NetworkConnectivity

class MovieRepository(private val remoteMovieDataSource: RemoteMovieDataSource,
                        private val localMovieDataSource: LocalMovieDataSource,
                        private val networkConnectivity: NetworkConnectivity){

    suspend fun queryMovies(query:String):List<Movie>{
        if(networkConnectivity.isNetworkAvailable){
            return remoteMovieDataSource.search(query).apply { localMovieDataSource.saveAll(this) }
        }
        return localMovieDataSource.searchMovies(query)
    }

    suspend fun listMovies():List<Movie>{
        return localMovieDataSource.getAll()
    }
    suspend fun findMovieById(id:String):Movie?{
        return localMovieDataSource.findById(id)
    }
}