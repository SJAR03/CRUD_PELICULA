package com.example.moviesqllite.repository

import androidx.lifecycle.LiveData
import com.example.moviesqllite.dao.ClasificacionDao
import com.example.moviesqllite.models.Clasificacion

class ClasificacionRepository(private val dao: ClasificacionDao) {
    val listado: LiveData<List<Clasificacion>> =
        dao.getAllRealData()

    suspend fun addClasificacion(clasificacion: Clasificacion) {
        dao.insert(clasificacion)
    }

    suspend fun updateClasificacion(clasificacion: Clasificacion) {
        dao.update(clasificacion)
    }

    suspend fun deleteClasificacion(clasificacion: Clasificacion) {
        dao.delete(clasificacion)
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }
}