package com.abba.pokemontcg.domain

import javax.persistence.*

@Entity
data class EnergyCard(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @ManyToOne
        val primaryType: Type

)