package com.example.moviesqllite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesqllite.databinding.ItemGeneroBinding
import com.example.moviesqllite.models.Genero

class GeneroAdapter(val list:List<Genero>): RecyclerView.Adapter<GeneroAdapter.GeneroViewHolder>(){

    private companion object DiffCallback : DiffUtil.ItemCallback<Genero>() {

        override fun areItemsTheSame(oldItem: Genero, newItem: Genero): Boolean =
            oldItem.id_Genero == newItem.id_Genero

        override fun areContentsTheSame(oldItem: Genero, newItem: Genero): Boolean =
            oldItem.nombre == newItem.nombre && oldItem.nombre == newItem.nombre

    }

    inner class GeneroViewHolder(private val binding: ItemGeneroBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(genero : Genero) = binding.run {
            itemNombre.text = genero.nombre
            itemId.text = genero.id_Genero.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneroViewHolder =
        GeneroViewHolder(ItemGeneroBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false))

    override fun onBindViewHolder(holder: GeneroViewHolder, position: Int) : Unit =
        holder.bind(list[position])

    override fun getItemCount(): Int =list.size
}