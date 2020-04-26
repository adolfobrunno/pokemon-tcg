package com.abba.pokemontcg.domain

import javax.persistence.*

@Entity(name="card")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="cardType",
        discriminatorType = DiscriminatorType.STRING)
open class Card(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) open val id: Int,
        open val name: String,
        open val description: String
)
