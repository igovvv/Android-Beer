package com.example.beercafesv1.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface FavouritesDatabaseDAO{

    @Insert
    suspend fun insert(favourite: Favourite)

    @Update
    suspend fun update(favourite: Favourite)

    @Query("DELETE FROM favourites_table")
    suspend fun clear()

    @Query("SELECT * FROM favourites_table ORDER BY favId DESC")
    fun getAllFavs(): LiveData<List<Favourite>>

}