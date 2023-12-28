package com.deanuharatinu.pokedexcleanarchitecture.di.factories

import com.deanuharatinu.pokemonlist.data.repository.PokemonRepoImpl
import com.deanuharatinu.pokemonlist.domain.repository.PokemonRepository

class PokemonRepositoryFactory {
    fun provide(): PokemonRepository {
        return PokemonRepoImpl()
    }
}