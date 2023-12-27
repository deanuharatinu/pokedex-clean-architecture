package com.deanuharatinu.pokemonlist.domain.model

data class PokemonDomainModel(
    val name: String,
    val image: String,
    val types: List<String>
)