package com.deanuharatinu.pokemonlist.domain.repository

import com.deanuharatinu.common.infra.domain.Resource
import com.deanuharatinu.pokemonlist.domain.model.PokemonResultDomainModel

fun interface PokemonRepository {
    fun pokemonList(): Resource<PokemonResultDomainModel>
}