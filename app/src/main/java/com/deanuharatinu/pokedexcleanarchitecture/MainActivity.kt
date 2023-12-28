package com.deanuharatinu.pokedexcleanarchitecture

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.ui.R.*
import com.deanuharatinu.favorite.R.id.favorite_pokemon_navigation
import com.deanuharatinu.favorite.ui.view.FavoritePokemonFragment
import com.deanuharatinu.feature.pokemonlist.R.id.pokemon_list_navigation
import com.deanuharatinu.pokedexcleanarchitecture.databinding.ActivityMainBinding
import com.deanuharatinu.pokedexcleanarchitecture.di.factories.GetPokemonDecoratorFactory
import com.deanuharatinu.pokemonlist.presentation.mapper.PokemonDomainToPresentationMapper
import com.deanuharatinu.pokemonlist.presentation.viewmodel.PokemonListViewModel
import com.deanuharatinu.pokemonlist.ui.view.PokemonListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var currentFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initNavBottom()
    }

    private fun initView() {
        val viewModel: PokemonListViewModel by viewModels { Factory }
        val initialFragment = PokemonListFragment.newInstance(viewModel)
        currentFragment = initialFragment
        replaceView(initialFragment)
    }

    private fun initNavBottom() {
        binding.navView.apply {
            menu.clear()
            inflateMenu(R.menu.bottom_nav_menu)

            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    pokemon_list_navigation -> {
                        if (currentFragment is PokemonListFragment) {
                            return@setOnItemSelectedListener false
                        }

                        val viewModel: PokemonListViewModel by viewModels { Factory }
                        val fragment = PokemonListFragment.newInstance(viewModel)
                        currentFragment = fragment
                        replaceView(fragment)
                        return@setOnItemSelectedListener true
                    }

                    favorite_pokemon_navigation -> {
                        if (currentFragment is FavoritePokemonFragment) {
                            return@setOnItemSelectedListener false
                        }

                        val fragment = FavoritePokemonFragment.newInstance()
                        currentFragment = fragment
                        replaceView(fragment)
                        return@setOnItemSelectedListener true
                    }

                    else -> throw IllegalAccessException()
                }
            }
        }
    }

    @SuppressLint("CommitTransaction")
    private fun destroyView() {
        binding.apply {
            val fragment = supportFragmentManager.findFragmentById(
                binding.navHostFragmentActivityMain.id
            )

            fragment?.let {
                supportFragmentManager
                    .beginTransaction()
                    .remove(it)
                    .commit()
            }
        }
    }

    @SuppressLint("CommitTransaction")
    private fun replaceView(fragment: Fragment) {
        destroyView()
        supportFragmentManager.commit {
            replace(binding.navHostFragmentActivityMain.id, fragment)
            addToBackStack(null)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                return PokemonListViewModel(
                    getPokemonUseCase = GetPokemonDecoratorFactory().provide(),
                    pokemonToPresentationMapper = PokemonDomainToPresentationMapper()
                ) as T
            }
        }
    }
}