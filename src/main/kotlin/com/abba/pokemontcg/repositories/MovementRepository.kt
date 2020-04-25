package com.abba.pokemontcg.repositories

import com.abba.pokemontcg.domain.Movement
import org.springframework.data.repository.CrudRepository

interface MovementRepository : CrudRepository<Movement, Int> {
}