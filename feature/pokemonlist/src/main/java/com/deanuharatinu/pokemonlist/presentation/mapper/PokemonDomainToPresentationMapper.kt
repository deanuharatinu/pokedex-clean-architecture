package com.deanuharatinu.pokemonlist.presentation.mapper

import com.deanuharatinu.pokemonlist.domain.model.PokemonDomainModel
import com.deanuharatinu.pokemonlist.presentation.model.PokemonPresentationModel

class PokemonDomainToPresentationMapper {
    fun toPresentation(pokemonDomainModel: PokemonDomainModel): PokemonPresentationModel {
        return PokemonPresentationModel(
            name = pokemonDomainModel.name,
            imageUrl = pokemonDomainModel.imageUrl,
            color = pokemonDomainModel.color
        )
    }
}