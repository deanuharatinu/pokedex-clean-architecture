package com.deanuharatinu.pokemonlist.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.deanuharatinu.feature.pokemonlist.databinding.FragmentPokemonListBinding
import com.deanuharatinu.pokemonlist.presentation.viewmodel.PokemonListViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PokemonListFragment(
    private val viewModel: PokemonListViewModel,
) : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentPokemonListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonListBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(
            viewModel: PokemonListViewModel
        ) = PokemonListFragment(viewModel).apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }
}