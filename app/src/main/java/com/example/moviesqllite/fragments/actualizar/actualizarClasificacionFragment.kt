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
import com.example.moviesqllite.databinding.FragmentActualizarClasificacionBinding
import com.example.moviesqllite.models.Clasificacion
import com.example.moviesqllite.viewmodels.ClasificacionViewModels
import kotlinx.android.synthetic.main.fragment_actualizar_clasificacion.*

class actualizarClasificacionFragment : Fragment(){

    lateinit var fBinding: FragmentActualizarClasificacionBinding
    private val args by navArgs<actualizarClasificacionFragmentArgs>()
    private lateinit var viewModel: ClasificacionViewModels
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fBinding =
            FragmentActualizarClasificacionBinding.inflate(layoutInflater)
        viewModel =
            ViewModelProvider(this).get(ClasificacionViewModels::class.java)
        with(fBinding) {

            AbreviacionClasificacion.setText(args.currentClasificacion.abreviacion)
            DescripcionClasificacion.setText(args.currentClasificacion.nombre)
            BtnActualizarClasificacion.setOnClickListener {
                GuardarCambios()
            }
        }
        //Agregar menu
        setHasOptionsMenu(true)
        return fBinding.root
    }
    private fun GuardarCambios() {
        val abreviacion = fBinding.AbreviacionClasificacion.text.toString()
        val descripcion = fBinding.DescripcionClasificacion.text.toString()
        //Crear el objeto
        val clasi =
            Clasificacion(args.currentClasificacion.idClasificacion, abreviacion, descripcion, true)
        //Actualizar
        viewModel.actualizarClasificacion(clasi)
        Toast.makeText(requireContext(), "Registro actualizado",
            Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.actualizar_Clasificacion)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater:
    MenuInflater
    ) {
        inflater.inflate(R.menu.delete_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        if (item.itemId == R.id.mnuEliminar) {
            eliminarClasificacion()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun eliminarClasificacion() {
        val alerta = AlertDialog.Builder(requireContext())
        alerta.setPositiveButton("Si") { _, _ ->
            viewModel.eliminarClasificacion(args.currentClasificacion)
            Toast.makeText(
                requireContext(),
                "Registro eliminado satisfactoriamente...",
                Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.actualizar_Clasificacion)
        }
        alerta.setNegativeButton("No") { _, _ ->
            Toast.makeText(
                requireContext(),
                "Operación cancelada...",
                Toast.LENGTH_LONG
            ).show()
        }
        alerta.setTitle("Eliminando ${args.currentClasificacion.abreviacion}")
        alerta.setMessage("¿Esta seguro de eliminar a ${args.currentClasificacion.abreviacion}?")
        alerta.create().show()
    }

}