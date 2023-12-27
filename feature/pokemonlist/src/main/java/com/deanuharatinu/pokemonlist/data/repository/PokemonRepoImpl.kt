package com.deanuharatinu.pokemonlist.data.repository

import com.deanuharatinu.common.infra.domain.Resource
import com.deanuharatinu.pokemonlist.domain.model.PokemonResultDomainModel
import com.deanuharatinu.pokemonlist.domain.repository.PokemonRepository

class PokemonRepoImpl : PokemonRepository {
    override fun pokemonList(): Resource<PokemonResultDomainModel> {
        TODO("Not yet implemented")
    }
}