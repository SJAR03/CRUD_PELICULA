package com.example.moviesqllite.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviesqllite.dao.ClasificacionDao
import com.example.moviesqllite.dao.GeneroDao
import com.example.moviesqllite.models.Clasificacion
import com.example.moviesqllite.models.Genero

interface MainDataBaseProvider{
    fun clasificacionDao() : ClasificacionDao
    fun generoDao() : GeneroDao
}

@Database(entities = [Clasificacion::class, Genero::class], version =1 )
abstract class MainDataBase: RoomDatabase(), MainDataBaseProvider {
    abstract override fun clasificacionDao(): ClasificacionDao
    abstract override fun generoDao(): GeneroDao

    companion object {
        @Volatile
        private var INSTANCE: MainDataBase? = null
        fun getInstace(context: Context): MainDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MainDataBase::class.java,
                        "database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}