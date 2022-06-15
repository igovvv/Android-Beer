package com.example.beercafesv1.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "favourites_table")
data class Favourite (

    @PrimaryKey(autoGenerate = true)
    var favId: Long = 0L,
            @ColumnInfo(name = "cafe_name")
            val cafeName: String = "Name",
                    @ColumnInfo(name = "cafe_city")
                    val city: String = "City",


)