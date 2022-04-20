package com.example.moviesqllite.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Clasificacion")
data class Clasificacion(
    @PrimaryKey(autoGenerate = true)
    val idClasificacion: Int,
    @ColumnInfo(name = "abreviacion")
    val abreviacion:String,
    @ColumnInfo(name = "nombre")
    val nombre:String,
    @ColumnInfo(name = "activo")
    val activo: Boolean
)