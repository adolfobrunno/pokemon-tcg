package com.abba.pokemontcg.domain

import junit.framework.Assert.assertEquals
import org.hibernate.cfg.Configuration
import org.hibernate.testing.junit4.BaseCoreFunctionalTestCase
import org.hibernate.testing.transaction.TransactionUtil
import org.junit.Test
import java.io.IOException
import java.util.*

class PokemonTest : BaseCoreFunctionalTestCase() {

    private val properties: Properties
        @Throws(IOException::class)
        get() {
            val properties = Properties()
            properties.load(javaClass.classLoader.getResourceAsStream("hibernate.properties"))
            return properties
        }

    override fun getAnnotatedClasses(): Array<Class<*>> {
        return arrayOf(Pokemon::class.java, Type::class.java)
    }

    override fun configure(configuration: Configuration) {
        super.configure(configuration)
        configuration.properties = properties
    }

    @Test
    fun givenAPokemon_whenSaved_thenFound(){

        TransactionUtil.doInHibernate(({this.sessionFactory()}), {
            session ->
            val grass = Type(1, "Grass")
            session.save(grass)
            val pokemon = Pokemon(1, "Bulbasaur", 1, grass , null);
            session.save(pokemon)
            val pokemonFound = session.find(Pokemon::class.java, pokemon.id)
            session.refresh(pokemonFound)
            assertEquals(pokemon, pokemonFound)
            assertEquals(grass, pokemon.primaryType)
        })


    }

}