package com.abba.pokemontcg.repositories

import com.abba.pokemontcg.domain.Type
import org.springframework.data.repository.CrudRepository


interface TypeRepository : CrudRepository<Type, Int> {
}