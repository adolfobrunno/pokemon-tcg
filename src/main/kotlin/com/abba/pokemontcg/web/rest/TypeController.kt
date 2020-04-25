package com.abba.pokemontcg.web.rest

import com.abba.pokemontcg.domain.Type
import com.abba.pokemontcg.repositories.TypeRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TypeController (val typeRepository: TypeRepository) {

    @PostMapping("/api/types")
    fun save(@RequestBody entity : Type) = typeRepository.save(entity)

    @GetMapping("/api/types")
    fun all() = run {
        val all = typeRepository.findAll()
        ResponseEntity.ok(all)
    }
}