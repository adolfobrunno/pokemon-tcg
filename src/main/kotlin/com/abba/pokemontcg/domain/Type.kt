package com.abba.pokemontcg.domain

import javax.persistence.*

@Entity
data class Type(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(nullable = false)
        val name: String
)