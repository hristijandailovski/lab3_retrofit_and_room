package com.hfad.lab3_retrofit_and_room.retrofit

import com.hfad.lab3_retrofit_and_room.model.MovieResponse
import retrofit2.Response
import retrofit2.http.Query

interface MovieDbApi {

    suspend fun search(@Query("s") query:String): Response<MovieResponse>
}