package com.example.moviesqllite.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moviesqllite.models.Clasificacion
import com.example.moviesqllite.models.Genero

@Dao
interface GeneroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(genero: Genero)

    @Query("SELECT * FROM Genero")
    suspend fun getAll(): List<Genero>

    @Query("SELECT * FROM Genero WHERE id_Genero = :id")
    suspend fun getById(id : Int) : Genero

    @Query("SELECT * FROM Genero")
    fun getAllRealData(): LiveData<List<Genero>>

    @Update
    suspend fun update(genero: Genero)

    @Delete
    suspend fun delete(genero: Genero)

    @Query("Delete from Genero")
    suspend fun deleteAll()
}