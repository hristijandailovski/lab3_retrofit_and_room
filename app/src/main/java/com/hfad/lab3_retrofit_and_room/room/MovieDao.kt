package com.hfad.lab3_retrofit_and_room.room

import androidx.room.*
import com.hfad.lab3_retrofit_and_room.model.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: Movie)

    @Delete
    suspend fun deleteMovie(movie: Movie)

    @Query("DELETE FROM movie WHERE imdbID=:id")
    suspend fun delete(id: String)

    @Query("SELECT * FROM movie")
    suspend fun getAll(): List<Movie>

    @Query("SELECT * FROM movie WHERE imdbID=:id")
    suspend fun findById(id:String):Movie?

    @Query("SELECT * FROM movie WHERE title LIKE :query")
    suspend fun searchMovies(query: String): List<Movie>

}