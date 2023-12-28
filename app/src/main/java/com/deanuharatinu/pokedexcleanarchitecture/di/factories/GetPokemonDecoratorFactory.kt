package com.deanuharatinu.pokedexcleanarchitecture.di.factories

import com.deanuharatinu.common.infra.domain.BaseUseCase
import com.deanuharatinu.common.infra.domain.Resource
import com.deanuharatinu.pokedexcleanarchitecture.di.decorators.GetPokemonUseCaseDecorator
import com.deanuharatinu.pokemonlist.domain.model.PokemonRequestDomainModel
import com.deanuharatinu.pokemonlist.domain.model.PokemonResultDomainModel

class GetPokemonDecoratorFactory {
    fun provide(): BaseUseCase<PokemonRequestDomainModel, Resource<PokemonResultDomainModel>> {
        return GetPokemonUseCaseDecorator(
            getPokemonUseCase = GetPokemonUseCaseFactory().provide(),
            savePokemonUseCase = SavePokemonUseCaseFactory().provide()
        )
    }
}