package com.deanuharatinu.pokemonlist.presentation.model

data class PokemonListViewState(
    val isLoading: Boolean = false,
    val pokemon: Collection<PokemonPresentationModel> = emptyList()
) {
    fun loading(): PokemonListViewState = copy(isLoading = true)

    fun withPokemon(pokemon: Collection<PokemonPresentationModel>) = copy(
        isLoading = false,
        pokemon = pokemon
    )
}