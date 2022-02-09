package com.example.pokedex.data.repository

import com.example.pokedex.data.api.APIInterface

class PokemonRepo constructor(private val apiInterface: APIInterface) {
    suspend fun getPokemonList() = apiInterface.getPokemons()


}