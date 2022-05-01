package com.example.moviesqllite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviesqllite.dao.GeneroDao
import com.example.moviesqllite.database.MainDataBase
import com.example.moviesqllite.databinding.FragmentAgregarGeneroBinding
import com.example.moviesqllite.models.Genero
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AgregarGeneroFragment : Fragment() {

    lateinit var binding: FragmentAgregarGeneroBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentAgregarGeneroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db: MainDataBase = MainDataBase.getInstace(this.requireContext().applicationContext)
        val dao: GeneroDao = db.generoDao()

        with(binding){
            btnGuardarGenero.setOnClickListener{
                val genero = Genero(
                    0,
                    generoNombre.text.toString(),
                    true
                )
                CoroutineScope(Dispatchers.Main).launch {
                    dao.insert(genero)
                }

                findNavController().navigate(R.id.IrAGenero)
            }
        }

    }

}