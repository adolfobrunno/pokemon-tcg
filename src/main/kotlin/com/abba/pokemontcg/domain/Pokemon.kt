package com.abba.pokemontcg.domain

import javax.persistence.*


@Entity
data class Pokemon(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(nullable = false)
    val name: String,

    val number: Int,

    @ManyToOne
    val primaryType: Type,

    @ManyToOne
    val secondaryType: Type ?


)
