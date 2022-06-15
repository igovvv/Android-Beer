package com.example.beercafesv1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Favourite::class], version = 1, exportSchema = false)
abstract class FavouritesDatabase: RoomDatabase() {

    abstract val favouritesDatabaseDAO: FavouritesDatabaseDAO


    companion object{

        @Volatile
        private var INSTANCE: FavouritesDatabase? = null

        fun getInstance(context: Context): FavouritesDatabase{
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavouritesDatabase::class.java,
                    "favourites_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}