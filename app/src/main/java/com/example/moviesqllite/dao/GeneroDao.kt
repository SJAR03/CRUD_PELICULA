package com.example.moviesqllite.dao

import androidx.room.*
import com.example.moviesqllite.models.Genero

@Dao
interface GeneroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(genero: Genero)

    @Query("SELECT * FROM Genero")
    suspend fun getAll(): List<Genero>

    @Query("SELECT * FROM Genero WHERE id_Genero = :id")
    suspend fun getById(id : Int) : Genero

    @Update
    fun update(genero: Genero)

    @Delete
    fun delete(genero: Genero)

}