package com.example.moviesqllite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesqllite.adapter.GeneroAdapter
import com.example.moviesqllite.dao.GeneroDao
import com.example.moviesqllite.database.MainDataBase
import com.example.moviesqllite.databinding.FragmentGeneroBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GeneroFragment : Fragment() {

    lateinit var binding: FragmentGeneroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGeneroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db: MainDataBase = MainDataBase.getInstace(this.requireContext().applicationContext)
        val dao: GeneroDao = db.generoDao()
        CoroutineScope(Dispatchers.Main).launch {
            val list = dao.getAll()
            binding.rvGenero.layoutManager = LinearLayoutManager(context)
            binding.rvGenero.adapter = GeneroAdapter(list)
        }

        binding.btnAgregarGenero.setOnClickListener {
            findNavController().navigate(R.id.irAAgregarGenero)
        }

    }
}