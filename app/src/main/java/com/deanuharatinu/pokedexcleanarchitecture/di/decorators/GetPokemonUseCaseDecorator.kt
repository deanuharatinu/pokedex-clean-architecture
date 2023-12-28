package com.deanuharatinu.pokedexcleanarchitecture.di.decorators

import com.deanuharatinu.common.infra.SaveDataException
import com.deanuharatinu.common.infra.domain.BaseUseCase
import com.deanuharatinu.common.infra.domain.Resource
import com.deanuharatinu.pokemonlist.domain.model.PokemonRequestDomainModel
import com.deanuharatinu.pokemonlist.domain.model.PokemonResultDomainModel
import com.deanuharatinu.pokemonlist.domain.usecase.GetPokemonUseCase
import com.deanuharatinu.pokemonlist.domain.usecase.SavePokemonUseCase

class GetPokemonUseCaseDecorator(
    private val getPokemonUseCase: GetPokemonUseCase,
    private val savePokemonUseCase: SavePokemonUseCase,
) : BaseUseCase<PokemonRequestDomainModel, Resource<PokemonResultDomainModel>>() {
    override fun execute(request: PokemonRequestDomainModel): Resource<PokemonResultDomainModel> {
        val result = getPokemonUseCase.execute(request)
        if (result is Resource.Success) {
            val saveResult = savePokemonUseCase.execute(result.data.pokemonDomainModels)
            if (!saveResult) return Resource.Error(SaveDataException())
        }

        return result
    }
}