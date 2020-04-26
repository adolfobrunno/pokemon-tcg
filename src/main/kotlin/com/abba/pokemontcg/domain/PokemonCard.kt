package com.abba.pokemontcg.domain

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
@DiscriminatorValue("PK")
class PokemonCard(
        id: Int,
        name: String,
        description: String,

        @ManyToOne
        val pokemon: Pokemon,

        val level: Int,

        val hp: Int,

        @ManyToOne
        val firstMovement: Movement,

        @ManyToOne
        val secondMovement: Movement? = null

) : Card(id, name, description)