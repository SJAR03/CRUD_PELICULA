package com.example.moviesqllite.fragments.actualizar

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.moviesqllite.R
import com.example.moviesqllite.databinding.FragmentActualizarGeneroBinding
import com.example.moviesqllite.models.Genero
import com.example.moviesqllite.viewmodels.GeneroViewModels

class actualizarGeneroFragment : Fragment(){

    lateinit var fBinding: FragmentActualizarGeneroBinding
    private val args by navArgs<actualizarGeneroFragmentArgs>()
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
        with(fBinding) {

            generoNombre.setText(args.currentGenero.nombre)
            btnGuardarGenero.setOnClickListener {
                GuardarCambios()
            }
        }
        //Agregar menu
        setHasOptionsMenu(true)
        return fBinding.root
    }
    private fun GuardarCambios() {
        val nombreGenero = fBinding.generoNombre.text.toString()
        //Crear el objeto
        val gen =
            Genero(args.currentGenero.id_Genero,nombreGenero,true)
        //Actualizar
        viewModel.actualizarGenero(gen)
        Toast.makeText(requireContext(), "Registro actualizado",
            Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.actualizar_Genero)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater:
    MenuInflater
    ) {
        inflater.inflate(R.menu.delete_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        if (item.itemId == R.id.mnuEliminar) {
            eliminarGenero()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun eliminarGenero() {
        val alerta = AlertDialog.Builder(requireContext())
        alerta.setPositiveButton("Si") { _, _ ->
            viewModel.eliminarGenero(args.currentGenero)
            Toast.makeText(
                requireContext(),
                "Registro eliminado satisfactoriamente...",
                Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.actualizar_Genero)
        }
        alerta.setNegativeButton("No") { _, _ ->
            Toast.makeText(
                requireContext(),
                "Operación cancelada...",
                Toast.LENGTH_LONG
            ).show()
        }
        alerta.setTitle("Eliminando ${args.currentGenero.nombre}")
        alerta.setMessage("¿Esta seguro de eliminar a ${args.currentGenero.nombre}?")
        alerta.create().show()
    }

}