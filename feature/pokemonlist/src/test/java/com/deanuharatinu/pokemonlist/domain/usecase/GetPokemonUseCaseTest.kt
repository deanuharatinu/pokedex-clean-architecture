package com.deanuharatinu.pokemonlist.domain.usecase

import com.deanuharatinu.common.infra.InvalidDataException
import com.deanuharatinu.common.infra.domain.Resource
import com.deanuharatinu.pokemonlist.domain.model.PaginationDomainModel
import com.deanuharatinu.pokemonlist.domain.model.PokemonDomainModel
import com.deanuharatinu.pokemonlist.domain.model.PokemonRequestDomainModel
import com.deanuharatinu.pokemonlist.domain.model.PokemonResultDomainModel
import com.deanuharatinu.pokemonlist.domain.repository.PokemonRepository
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.given
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class GetPokemonUseCaseTest {
    @Mock
    private lateinit var pokemonRepository: PokemonRepository

    @Mock
    private lateinit var pokemonRequestDomainModel: PokemonRequestDomainModel
    private lateinit var systemUnderTest: GetPokemonUseCase

    @Before
    fun setUp() {
        systemUnderTest = GetPokemonUseCase(
            pokemonRepository
        )
    }

    @Test
    fun `when GetPokemonUseCase-execute then return Resource-Success with empty list`() {
        // Arrange
        val pokemonRequestDomainModel = PokemonRequestDomainModel(
            limit = 10,
            offset = 1
        )
        val pokemonResultDomainModel = PokemonResultDomainModel(
            paginationDomainModel = PaginationDomainModel(1, "", ""),
            pokemonDomainModels = emptyList()
        )
        given(pokemonRepository.pokemonList()).willReturn(Resource.Success(pokemonResultDomainModel))

        // Action
        val result = systemUnderTest.execute(pokemonRequestDomainModel)

        // Assert
        assertTrue(result is Resource.Success)
        val actualResult = (result as Resource.Success).data
        assertNotNull(actualResult.pokemonDomainModels)
        assertEquals(0, actualResult.pokemonDomainModels.size)
        verify(pokemonRepository, times(1)).pokemonList()
    }

    @Test
    fun `when GetPokemonUseCase-execute then return Resource-Success with matching value`() {
        // Arrange
        val pokemonRequestDomainModel = PokemonRequestDomainModel(
            limit = 10,
            offset = 1
        )
        val pokemonDomainModel = PokemonDomainModel(
            name = "Bulba",
            image = "image 1",
            types = listOf("Grass", "Poison")
        )
        val pokemonResultDomainModel = PokemonResultDomainModel(
            paginationDomainModel = PaginationDomainModel(1, "", ""),
            pokemonDomainModels = listOf(pokemonDomainModel)
        )
        given(pokemonRepository.pokemonList()).willReturn(Resource.Success(pokemonResultDomainModel))

        // Action
        val result = systemUnderTest.execute(pokemonRequestDomainModel)

        // Assert
        assertTrue(result is Resource.Success)
        val actualResult = (result as Resource.Success).data
        assertNotNull(actualResult.pokemonDomainModels)
        assertEquals(1, actualResult.pokemonDomainModels.size)
        val actualDomainModel = actualResult.pokemonDomainModels[0]
        assertEquals(pokemonDomainModel.name, actualDomainModel.name)
        assertEquals(pokemonDomainModel.image, actualDomainModel.image)
        assertEquals(pokemonDomainModel.types, actualDomainModel.types)
        verify(pokemonRepository, times(1)).pokemonList()
    }

    @Test
    fun `when GetPokemonUseCase-execute then return Resource-Error with matching value`() {
        // Arrange
        given(pokemonRepository.pokemonList())
            .willReturn(Resource.Error(InvalidDataException()))

        // Action
        val result = systemUnderTest.execute(pokemonRequestDomainModel)

        // Assert
        assertTrue(result is Resource.Error)
        val actualException = (result as Resource.Error).error
        assertNotNull(actualException)
        assertTrue(actualException is InvalidDataException)
        verify(pokemonRepository, times(1)).pokemonList()
    }
}