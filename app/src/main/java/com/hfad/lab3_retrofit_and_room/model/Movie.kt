package com.hfad.lab3_retrofit_and_room.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Movie(@SerializedName("Title") val title:String,
                 @SerializedName("Year") val year:String,
                 @PrimaryKey(autoGenerate = false)val imdbID:String,
                 @SerializedName("Type") val type:String,
                 @SerializedName("Poster") val poster:String) {
}