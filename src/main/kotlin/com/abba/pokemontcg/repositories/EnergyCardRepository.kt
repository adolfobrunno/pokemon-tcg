package com.abba.pokemontcg.repositories

import com.abba.pokemontcg.domain.EnergyCard
import org.springframework.data.repository.CrudRepository

interface EnergyCardRepository : CrudRepository<EnergyCard, Int> {
}