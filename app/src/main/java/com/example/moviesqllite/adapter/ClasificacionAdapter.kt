package com.example.moviesqllite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesqllite.databinding.FragmentClasificacionBinding
import com.example.moviesqllite.databinding.FragmentListaClasificacionBinding
import com.example.moviesqllite.fragments.lista.ListaClasificacionFragmentDirections
import com.example.moviesqllite.models.Clasificacion

class ClasificacionAdapter :
    RecyclerView.Adapter<ClasificacionAdapter.ClasificacionHolder>() {
    private var listadoClasificacion = emptyList<Clasificacion>()
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType:
        Int
    ): ClasificacionHolder {
        val binding =

            FragmentListaClasificacionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        return ClasificacionHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ClasificacionHolder,
        position: Int
    ) {
        holder.bind(
            listadoClasificacion[position]
        )
    }

    override fun getItemCount(): Int = listadoClasificacion.size
    fun setData(clasi: List<Clasificacion>) {
        this.listadoClasificacion = clasi
        notifyDataSetChanged()
    }

    inner class ClasificacionHolder(val binding: FragmentListaClasificacionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(clasificacion: Clasificacion) {
            with(binding) {
                itemId.text = clasificacion.idClasificacion.toString()
                itemAbreviatura.text = clasificacion.abreviacion
                itemNombre.text = clasificacion.nombre
                itemClasificacion.setOnClickListener {
                    val action =
                        ListaClasificacionFragmentDirections.clasificacionActualizar(clasificacion)
                    it.findNavController().navigate(action)
                }
            }
        }
    }
}