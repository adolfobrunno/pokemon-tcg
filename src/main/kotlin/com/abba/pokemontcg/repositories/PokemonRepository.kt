package com.abba.pokemontcg.repositories

import com.abba.pokemontcg.domain.Pokemon
import org.springframework.data.repository.CrudRepository

interface PokemonRepository : CrudRepository<Pokemon, Int> {
}