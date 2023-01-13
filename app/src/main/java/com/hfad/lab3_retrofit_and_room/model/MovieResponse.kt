package com.hfad.lab3_retrofit_and_room.model

import com.google.gson.annotations.SerializedName


data class MovieResponse(@SerializedName("Search") val search:List<Movie>,
                         val totalResults:Int,
                         @SerializedName("Response") val response:String)



//data class MovieResponse(@SerializedName("Title") val title:String,
//                        @SerializedName("Year") val year:Int,
//                        val imdbID:String,
//                        @SerializedName("Type") val type:String,
//                        @SerializedName("Poster") val poster:String) {
//}