package com.abba.pokemontcg

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PokemonTcgApplication

fun main(args: Array<String>) {
    runApplication<PokemonTcgApplication>(*args)
}
