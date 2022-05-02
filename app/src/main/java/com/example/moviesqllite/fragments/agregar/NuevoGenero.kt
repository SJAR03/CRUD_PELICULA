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
import com.example.moviesqllite.databinding.FragmentActualizarGeneroBinding
import com.example.moviesqllite.models.Genero
import com.example.moviesqllite.viewmodels.GeneroViewModels

class NuevoGenero : Fragment() {
    lateinit var fBinding: FragmentActualizarGeneroBinding
    private lateinit var viewModel: GeneroViewModels
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// Inflate the layout for this fragment
        fBinding =
            FragmentActualizarGeneroBinding.inflate(layoutInflater)
        viewModel =
            ViewModelProvider(this).get(GeneroViewModels::class.java)
        fBinding.btnGuardarGenero.setOnClickListener {
            guardarRegistro()
        }
        return fBinding.root
    }
    private fun guardarRegistro() {
        //val baseDatos = MainBaseDatos.getDataBase(this)
        val nombreGenero = fBinding.generoNombre.text.toString()
        //Crear objeto
        val genero = Genero(0, nombreGenero, true)
        //Agregar nueva clasificacion
        viewModel.agregarGenero(genero)
        Toast.makeText(requireContext(), "Registro guardado",
            Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.IrAGenero)
    }
}