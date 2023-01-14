package com.hfad.lab3_retrofit_and_room.model

import com.google.gson.annotations.SerializedName

data class Movie(@SerializedName("Title") val title:String,
                 @SerializedName("Year") val year:String,
                 val imdbID:String,
                 @SerializedName("Type") val type:String,
                 @SerializedName("Poster") val poster:String) {
}