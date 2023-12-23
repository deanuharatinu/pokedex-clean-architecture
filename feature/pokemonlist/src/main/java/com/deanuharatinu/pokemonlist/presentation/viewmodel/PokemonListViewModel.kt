package com.deanuharatinu.pokemonlist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.deanuharatinu.pokemonlist.domain.usecase.GetPokemonUseCase
import com.deanuharatinu.pokemonlist.presentation.mapper.PokemonDomainToPresentationMapper
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

private typealias DoNothing = Unit

class PokemonListViewModel(
    private val getPokemonUseCase: GetPokemonUseCase,
    private val pokemonToPresentationMapper: PokemonDomainToPresentationMapper,
) : ViewModel() {
    private val _viewState = MutableSharedFlow<String>()
    val viewState = _viewState.asSharedFlow()

}