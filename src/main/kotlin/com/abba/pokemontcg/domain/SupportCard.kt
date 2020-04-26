package com.abba.pokemontcg.domain

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("SP")
class SupportCard(id: Int, name: String, description: String
) : Card(id, name, description)