package com.deanuharatinu.pokemonlist.domain.repository

import com.deanuharatinu.pokemonlist.domain.model.PokemonDomainModel

fun interface PokemonRepository {
    fun pokemons(): List<PokemonDomainModel>
}