package com.example.moviesqllite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesqllite.databinding.ItemGeneroBinding
import com.example.moviesqllite.fragments.lista.ListaGeneroFragmentDirections
import com.example.moviesqllite.models.Clasificacion
import com.example.moviesqllite.models.Genero

class GeneroAdapter :
    RecyclerView.Adapter<GeneroAdapter.GeneroHolder>() {
    private var listadoGenero = emptyList<Genero>()
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType:
        Int
    ): GeneroHolder {
        val binding =

            ItemGeneroBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        return GeneroHolder(binding)
    }

    override fun onBindViewHolder(
        holder: GeneroHolder,
        position: Int
    ) {
        holder.bind(
            listadoGenero[position]
        )
    }

    override fun getItemCount(): Int = listadoGenero.size
    fun setData(gen: List<Genero>) {
        this.listadoGenero = gen
        notifyDataSetChanged()
    }

    inner class GeneroHolder(val binding: ItemGeneroBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(genero: Genero) {
            with(binding) {
                itemId.text = genero.id_Genero.toString()
                itemNombre.text = genero.nombre
                itemGenero.setOnClickListener {
                    val action =
                        ListaGeneroFragmentDirections.generoActualizar(genero)
                    it.findNavController().navigate(action)
                }
            }
        }
    }
}