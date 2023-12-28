package com.deanuharatinu.pokemonlist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.deanuharatinu.common.infra.domain.BaseUseCase
import com.deanuharatinu.common.infra.domain.Resource
import com.deanuharatinu.pokemonlist.domain.model.PokemonRequestDomainModel
import com.deanuharatinu.pokemonlist.domain.model.PokemonResultDomainModel
import com.deanuharatinu.pokemonlist.presentation.mapper.PokemonDomainToPresentationMapper
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class PokemonListViewModel(
    private val getPokemonUseCase: BaseUseCase<PokemonRequestDomainModel, Resource<PokemonResultDomainModel>>,
    private val pokemonToPresentationMapper: PokemonDomainToPresentationMapper,
) : ViewModel() {
    private val _viewState = MutableSharedFlow<String>()
    val viewState = _viewState.asSharedFlow()

    fun onEntered() {
        val request = PokemonRequestDomainModel(
            limit = 1,
            offset = 10
        )
        getPokemonUseCase.execute(request)
    }
}