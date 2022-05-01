package com.example.moviesqllite.fragments.agregar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.moviesqllite.R
import com.example.moviesqllite.databinding.FragmentAgregarClasificacionBinding
import com.example.moviesqllite.models.Clasificacion
import com.example.moviesqllite.viewmodels.ClasificacionViewModels

class NuevaClasificacion : Fragment() {
    lateinit var fBinding: FragmentAgregarClasificacionBinding
    private lateinit var viewModel: ClasificacionViewModels
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// Inflate the layout for this fragment
        fBinding =
            FragmentAgregarClasificacionBinding.inflate(layoutInflater)
        viewModel =
            ViewModelProvider(this).get(ClasificacionViewModels::class.java)
        fBinding.BtnGuardarClasificacion.setOnClickListener {
            guardarRegistro()
        }
        return fBinding.root
    }
    private fun guardarRegistro() {
        //val baseDatos = MainBaseDatos.getDataBase(this)
        val abreviacion = fBinding.AbreviacionClasificacion.text.toString()
        val descripcion = fBinding.DescripcionClasificacion.text.toString()
        //Crear objeto
        val clasificacion = Clasificacion(0, abreviacion, descripcion, true)
        //Agregar nueva clasificacion
        viewModel.agregarClasificacion(clasificacion)
        Toast.makeText(requireContext(), "Registro guardado",
            Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.IrAClasificacion)
    }
}