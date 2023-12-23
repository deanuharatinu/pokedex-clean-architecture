package com.deanuharatinu.pokemonlist.domain.usecase

import com.deanuharatinu.pokemonlist.domain.model.PokemonDomainModel
import com.deanuharatinu.pokemonlist.domain.repository.PokemonRepository

class GetPokemonUseCase(
    private val pokemonRepository: PokemonRepository,
) {
    fun execute(): List<PokemonDomainModel> {
        return pokemonRepository.pokemons()
    }
}