package com.example.moviesqllite.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Nacionalidad")
data class Nacionalidad (
    @PrimaryKey(autoGenerate = true)
    val id_Nacionalidad:Int,
    @ColumnInfo(name = "nombre")
    val nombre:String,
    @ColumnInfo(name = "activo")
    val activo:Boolean
)