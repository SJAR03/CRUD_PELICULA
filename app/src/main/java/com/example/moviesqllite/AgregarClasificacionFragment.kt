package com.example.moviesqllite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviesqllite.dao.ClasificacionDao
import com.example.moviesqllite.database.MainDataBase
import com.example.moviesqllite.databinding.FragmentAgregarClasificacionBinding
import com.example.moviesqllite.models.Clasificacion
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AgregarClasificacionFragment : Fragment() {

    lateinit var binding: FragmentAgregarClasificacionBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentAgregarClasificacionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db: MainDataBase = MainDataBase.getInstace(this.requireContext().applicationContext)
        val dao: ClasificacionDao = db.clasificacionDao()

        with(binding){
            btnGuardarClasificacion.setOnClickListener{
                val clasificacion = Clasificacion(
                    0,
                    clasificacionAbreviacion.text.toString(),
                    clasificacionDescripcion.text.toString(),
                    true
                )
                CoroutineScope(Dispatchers.Main).launch {
                    dao.insert(clasificacion)
                }

                findNavController().navigate(R.id.IrAClasificacion)
            }
        }

    }

}