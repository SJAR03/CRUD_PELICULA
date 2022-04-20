package com.example.moviesqllite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesqllite.adapter.ClasificacionAdapter
import com.example.moviesqllite.dao.ClasificacionDao
import com.example.moviesqllite.database.MainDataBase
import com.example.moviesqllite.databinding.FragmentClasificacionBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClasificacionFragment : Fragment() {

    lateinit var binding: FragmentClasificacionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentClasificacionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db: MainDataBase = MainDataBase.getInstace(this.requireContext().applicationContext)
        val dao: ClasificacionDao = db.clasificacionDao()
        CoroutineScope(Dispatchers.Main).launch {
            val list = dao.getAll()
            binding.rvClasificacion.layoutManager = LinearLayoutManager(context)
            binding.rvClasificacion.adapter = ClasificacionAdapter(list)
        }

        binding.btnAgregarClasificacion.setOnClickListener {
            findNavController().navigate(R.id.irAAgregarClasificacion)
        }

    }
}