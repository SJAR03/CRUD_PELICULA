package com.example.moviesqllite.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moviesqllite.models.Clasificacion

@Dao
interface ClasificacionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(clasificacion: Clasificacion)

    @Query("SELECT * FROM Clasificacion")
    suspend fun getAll(): List<Clasificacion>

    @Query("SELECT * FROM Clasificacion WHERE idClasificacion = :id")
    suspend fun getById(id : Int) : Clasificacion

    @Query("SELECT * FROM Clasificacion")
    fun getAllRealData(): LiveData<List<Clasificacion>>

    @Update
    suspend fun update(clasificacion: Clasificacion)

    @Delete
    suspend fun delete(clasificacion: Clasificacion)

    @Query("Delete from Clasificacion")
    suspend fun deleteAll()
}