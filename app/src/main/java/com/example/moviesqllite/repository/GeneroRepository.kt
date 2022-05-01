package com.example.moviesqllite.repository

import androidx.lifecycle.LiveData
import com.example.moviesqllite.dao.GeneroDao
import com.example.moviesqllite.models.Genero

class GeneroRepository(private val dao: GeneroDao) {
    val listado: LiveData<List<Genero>> =
        dao.getAllRealData()

    suspend fun addGenero(genero: Genero) {
        dao.insert(genero)
    }

    suspend fun updateGenero(genero: Genero) {
        dao.update(genero)
    }

    suspend fun deleteGenero(genero: Genero) {
        dao.delete(genero)
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }
}