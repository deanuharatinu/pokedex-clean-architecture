package com.deanuharatinu.pokemonlist.domain.usecase

import com.deanuharatinu.common.infra.domain.BaseUseCase
import com.deanuharatinu.common.infra.domain.Resource
import com.deanuharatinu.pokemonlist.domain.model.PokemonRequestDomainModel
import com.deanuharatinu.pokemonlist.domain.model.PokemonResultDomainModel
import com.deanuharatinu.pokemonlist.domain.repository.PokemonRepository

class GetPokemonUseCase(
    private val pokemonRepository: PokemonRepository,
) : BaseUseCase<PokemonRequestDomainModel, Resource<PokemonResultDomainModel>>() {
    override fun execute(
        request: PokemonRequestDomainModel
    ): Resource<PokemonResultDomainModel> {
        return pokemonRepository.pokemonList()
    }
}