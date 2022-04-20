package com.example.moviesqllite.dao

import androidx.room.*
import com.example.moviesqllite.models.Clasificacion

@Dao
interface ClasificacionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(usuario: Clasificacion)

    @Query("SELECT * FROM Clasificacion")
    suspend fun getAll(): List<Clasificacion>

    @Query("SELECT * FROM Clasificacion WHERE idClasificacion = :id")
    suspend fun getById(id : Int) : Clasificacion

    @Update
    fun update(usuario: Clasificacion)

    @Delete
    fun delete(usuario: Clasificacion)

}