package com.abba.pokemontcg.domain

import javax.persistence.*

@Entity
data class PokemonCard(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @ManyToOne
        val pokemon: Pokemon,

        @Column(nullable = false)
        val level: Int,

        @Column(nullable = false)
        val hp: Int,

        @ManyToOne
        val firstMovement: Movement,

        @ManyToOne
        val secondMovement: Movement ?= null


)