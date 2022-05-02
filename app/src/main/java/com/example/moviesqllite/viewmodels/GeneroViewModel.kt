package com.example.moviesqllite.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesqllite.database.MainDataBase
import com.example.moviesqllite.models.Clasificacion
import com.example.moviesqllite.models.Genero
import com.example.moviesqllite.repository.ClasificacionRepository
import com.example.moviesqllite.repository.GeneroRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GeneroViewModels(application: Application): AndroidViewModel(application) {
    val lista : LiveData<List<Genero>>
    private val repository: GeneroRepository
    init {
        val generoDao =
            MainDataBase.getInstace(application).generoDao()
        repository = GeneroRepository(generoDao)
        lista = repository.listado
    }
    fun agregarGenero(genero: Genero){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addGenero(genero)
        }
    }
    fun actualizarGenero(genero: Genero){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateGenero(genero)
        }
    }
    fun eliminarGenero(genero: Genero){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteGenero(genero)
        }
    }
    fun eliminarTodo(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }
}