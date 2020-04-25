package com.abba.pokemontcg.web.rest

import com.abba.pokemontcg.domain.Pokemon
import com.abba.pokemontcg.repositories.PokemonRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PokemonController (val pokemonRepository: PokemonRepository) {

    @PostMapping("/api/pokemons")
    fun save(@RequestBody entity : Pokemon) = pokemonRepository.save(entity)

    @GetMapping("/api/pokemons")
    fun all() = run { val findAll = pokemonRepository.findAll()
        ResponseEntity.ok(findAll)
    }

}