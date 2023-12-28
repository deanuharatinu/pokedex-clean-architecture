package com.deanuharatinu.pokedexcleanarchitecture.di.factories

import com.deanuharatinu.pokemonlist.domain.usecase.SavePokemonUseCase

class SavePokemonUseCaseFactory {
    fun provide(): SavePokemonUseCase {
        val repository = PokemonRepositoryFactory().provide()
        return SavePokemonUseCase(
            pokemonRepository = repository
        )
    }
}