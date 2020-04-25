package com.abba.pokemontcg.repositories

import com.abba.pokemontcg.domain.PokemonCard
import org.springframework.data.repository.CrudRepository

interface PokemonCardRepository : CrudRepository<PokemonCard, Int> {
}