package com.example.moviesqllite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesqllite.databinding.ItemClasificacionBinding
import com.example.moviesqllite.models.Clasificacion

class ClasificacionAdapter(val list:List<Clasificacion>): RecyclerView.Adapter<ClasificacionAdapter.ClasificacionViewHolder>(){

    private companion object DiffCallback : DiffUtil.ItemCallback<Clasificacion>() {

        override fun areItemsTheSame(oldItem: Clasificacion, newItem: Clasificacion): Boolean =
            oldItem.idClasificacion == newItem.idClasificacion

        override fun areContentsTheSame(oldItem: Clasificacion, newItem: Clasificacion): Boolean =
            oldItem.abreviacion == newItem.abreviacion && oldItem.nombre == newItem.nombre

    }

    inner class ClasificacionViewHolder(private val binding: ItemClasificacionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clasificacion : Clasificacion) = binding.run {
            itemAbreviatura.text = clasificacion.abreviacion
            itemId.text = clasificacion.idClasificacion.toString()
            itemNombre.text = clasificacion.nombre
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClasificacionViewHolder =
        ClasificacionViewHolder(ItemClasificacionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false))

    override fun onBindViewHolder(holder: ClasificacionViewHolder, position: Int) : Unit =
        holder.bind(list[position])

    override fun getItemCount(): Int =list.size
}