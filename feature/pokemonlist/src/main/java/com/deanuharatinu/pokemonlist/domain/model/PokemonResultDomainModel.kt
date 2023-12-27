package com.deanuharatinu.pokemonlist.domain.model

data class PokemonResultDomainModel(
    val paginationDomainModel: PaginationDomainModel,
    val pokemonDomainModels: List<PokemonDomainModel>
)