package com.abba.pokemontcg.domain

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
@DiscriminatorValue("EN")
class EnergyCard(

        id: Int,
        name: String,
        description: String,
        @ManyToOne
        val primaryType: Type

): Card(id, name, description)