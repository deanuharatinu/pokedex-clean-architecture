package com.deanuharatinu.pokemonlist.domain.model

data class PaginationDomainModel(
    val count: Int,
    val next: String,
    val previous: String,
)
