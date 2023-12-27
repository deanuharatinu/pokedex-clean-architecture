package com.deanuharatinu.pokemonlist.data.datasource

import com.deanuharatinu.common.infra.domain.Resource
import com.deanuharatinu.pokemonlist.domain.model.PokemonDomainModel

fun interface PokemonDataSource {
    fun pokemonList(): Resource<List<PokemonDomainModel>>
}