package com.deanuharatinu.pokemonlist.domain.usecase

import com.deanuharatinu.common.infra.domain.BaseUseCase
import com.deanuharatinu.pokemonlist.domain.model.PokemonDomainModel
import com.deanuharatinu.pokemonlist.domain.repository.PokemonRepository

class SavePokemonUseCase(
    private val pokemonRepository: PokemonRepository,
) : BaseUseCase<List<PokemonDomainModel>, Boolean>() {
    override fun execute(request: List<PokemonDomainModel>): Boolean {
        return true
    }
}