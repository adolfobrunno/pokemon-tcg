package com.abba.pokemontcg.domain

import org.hibernate.cfg.Configuration
import org.hibernate.testing.junit4.BaseCoreFunctionalTestCase
import org.hibernate.testing.transaction.TransactionUtil.doInHibernate
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.IOException
import java.util.*

internal class PokemonCardTest : BaseCoreFunctionalTestCase() {

    private val properties: Properties
        @Throws(IOException::class)
        get() {
            val properties = Properties()
            properties.load(javaClass.classLoader.getResourceAsStream("hibernate.properties"))
            return properties
        }

    override fun getAnnotatedClasses(): Array<Class<*>> {
        return arrayOf(Pokemon::class.java, Type::class.java, EnergyCard::class.java, Movement::class.java, PokemonCard::class.java)
    }

    override fun configure(configuration: Configuration) {
        super.configure(configuration)
        configuration.properties = properties
    }

    @Test
    fun givenAPokemonCard_whenSaved_ThenReturnTheCard() {

        doInHibernate(({this.sessionFactory()}), {
            session ->
            val grass = Type(1, "Grass")
            val normal = Type(2, "Normal")
            session.save(grass)
            session.save(normal)

            val bulbasaur = Pokemon(1, "Bulbasaur", 1, grass, null)
            session.save(bulbasaur)

            val normalEnergyCard = EnergyCard(1, normal)
            session.save(normalEnergyCard)

            val tackle = Movement(1, "Tackle", "", normal, MovementCategory.PHYSICAL, 10, arrayOf(normalEnergyCard).asList())
            session.save(tackle)

            val card = PokemonCard(1, bulbasaur, 10, 50, tackle)
            session.save(card)

            val find = session.find(PokemonCard::class.java, card.id)
            assertEquals(card, find)

        })

    }

}