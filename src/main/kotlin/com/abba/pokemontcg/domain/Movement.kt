package com.abba.pokemontcg.domain

import javax.persistence.*

@Entity
data class Movement (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(nullable=false)
        val name:String,

        val description: String,

        @ManyToOne
        val type: Type,

        @Enumerated(EnumType.STRING)
        val movementCategory: MovementCategory,

        val power: Int ?= 0,

        @ManyToMany(fetch = FetchType.EAGER)
        val requiredEnergies: List<EnergyCard>





)