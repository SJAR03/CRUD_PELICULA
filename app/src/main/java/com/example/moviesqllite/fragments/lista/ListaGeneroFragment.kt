package com.example.moviesqllite.fragments.lista

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesqllite.R
import androidx.lifecycle.Observer
import com.example.moviesqllite.adapter.GeneroAdapter
import com.example.moviesqllite.databinding.FragmentGeneroBinding
import com.example.moviesqllite.viewmodels.GeneroViewModels

class ListaGeneroFragment : Fragment() {

    lateinit var fBinding: FragmentGeneroBinding
    private lateinit var viewModel : GeneroViewModels
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fBinding = FragmentGeneroBinding.inflate(layoutInflater)
        val adapter = GeneroAdapter()
        val recycleView = fBinding.rvGenero
        recycleView.adapter = adapter
        recycleView.layoutManager =
            LinearLayoutManager(requireContext())
        viewModel =
            ViewModelProvider(this).get(GeneroViewModels::class.java)
        viewModel.lista.observe(viewLifecycleOwner, Observer
        {user->
            adapter.setData(user)
        })
        //Agregar el menu
        setHasOptionsMenu(true)
        return fBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState:
    Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        returnMenu()
    }
    private fun setupViews() {
        with(fBinding) {
            btnAgregarGenero.setOnClickListener {

                it.findNavController().navigate(R.id.irAAgregarGenero)
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater:
    MenuInflater
    ) {
        inflater.inflate(R.menu.delete_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        if (item.itemId == R.id.mnuEliminar) {
            eliminarTodo()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun eliminarTodo() {
        val alerta = AlertDialog.Builder(requireContext())
        alerta.setPositiveButton("Si") { _, _ ->
            viewModel.eliminarTodo()
            Toast.makeText(
                requireContext(),
                "Registros eliminados satisfactoriamente...",
                Toast.LENGTH_LONG
            ).show()
        }
        alerta.setNegativeButton("No") { _, _ ->
            Toast.makeText(
                requireContext(),
                "Operación cancelada...",
                Toast.LENGTH_LONG
            ).show()
        }
        alerta.setTitle("Eliminando todos los registro")
        alerta.setMessage("¿Esta seguro de eliminar los registros?")
        alerta.create().show()
    }

    private fun returnMenu() {
        with(fBinding) {
            btnRegresarMenu.setOnClickListener {

                it.findNavController().navigate(R.id.regresarMenuGenero)
            }
        }
    }

}