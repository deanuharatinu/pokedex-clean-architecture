package com.deanuharatinu.pokemonlist.presentation.mapper

import com.deanuharatinu.pokemonlist.domain.model.PokemonDomainModel
import com.deanuharatinu.pokemonlist.presentation.model.PokemonPresentationModel

class PokemonDomainToPresentationMapper {
    fun toPresentation(pokemonModel: PokemonDomainModel): PokemonPresentationModel {
        return PokemonPresentationModel(
            name = pokemonModel.name,
            image = pokemonModel.image,
            types = pokemonModel.types
        )
    }
}