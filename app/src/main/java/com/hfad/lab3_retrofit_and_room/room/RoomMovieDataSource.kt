package com.hfad.lab3_retrofit_and_room.room

import com.hfad.lab3_retrofit_and_room.model.LocalMovieDataSource
import com.hfad.lab3_retrofit_and_room.model.Movie

class RoomMovieDataSource(private val movieDao: MovieDao): LocalMovieDataSource {
    override suspend fun insert(movie: Movie) {
        movieDao.insert(movie)
    }

    override suspend fun saveAll(movies: List<Movie>) {
        movies.forEach {
            movieDao.insert(it)
        }
    }

    override suspend fun delete(id: String) {
        movieDao.delete(id)
    }

    override suspend fun findById(id: String): Movie? {
        return movieDao.findById(id)
    }

    override suspend fun getAll(): List<Movie> {
        return movieDao.getAll()
    }

    override suspend fun searchMovies(query: String): List<Movie> {
        return movieDao.searchMovies(query)
    }
}