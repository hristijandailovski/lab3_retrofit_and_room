package com.hfad.lab3_retrofit_and_room.retrofit

import com.hfad.lab3_retrofit_and_room.model.Movie
import com.hfad.lab3_retrofit_and_room.model.RemoteMovieDataSource

class RetrofitMovieDataSource(private val movieDbApi: MovieDbApi): RemoteMovieDataSource {


    override suspend fun search(query: String): List<Movie> {
        val movieResponse = movieDbApi.search(query)
        val responseBody = movieResponse.body()
        if (movieResponse.isSuccessful && responseBody!=null) {
            return responseBody.search
        }
        throw Exception(movieResponse.message())
    }
}