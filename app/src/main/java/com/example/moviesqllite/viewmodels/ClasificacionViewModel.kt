package com.example.moviesqllite.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesqllite.database.MainDataBase
import com.example.moviesqllite.models.Clasificacion
import com.example.moviesqllite.repository.ClasificacionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClasificacionViewModels(application: Application): AndroidViewModel(application) {
    val lista : LiveData<List<Clasificacion>>
    private val repository: ClasificacionRepository
    init {
        val clasificacionDao =
            MainDataBase.getInstace(application).clasificacionDao()
        repository = ClasificacionRepository(clasificacionDao)
        lista = repository.listado
    }
    fun agregarClasificacion(clasificacion: Clasificacion){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addClasificacion(clasificacion)
        }
    }
    fun actualizarClasificacion(clasificacion: Clasificacion){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateClasificacion(clasificacion)
        }
    }
    fun eliminarClasificacion(clasificacion: Clasificacion){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteClasificacion(clasificacion)
        }
    }
    fun eliminarTodo(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }
}