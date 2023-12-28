package com.deanuharatinu.pokedexcleanarchitecture.di.factories

import com.deanuharatinu.pokemonlist.domain.usecase.GetPokemonUseCase

class GetPokemonUseCaseFactory {
    fun provide(): GetPokemonUseCase {
        val pokemonRepository = PokemonRepositoryFactory().provide()
        return GetPokemonUseCase(
            pokemonRepository
        )
    }
}