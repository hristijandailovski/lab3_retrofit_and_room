package com.hfad.lab3_retrofit_and_room.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hfad.lab3_retrofit_and_room.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase() {
    abstract fun movieDao():MovieDao

    companion object{
        @Volatile
        private var INSTANCE:AppDatabase?=null

        @JvmStatic
        fun getDatabase(context: Context):AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context,AppDatabase::class.java,"movies").build()
                INSTANCE=instance
                instance
            }
        }
    }
}