package com.abba.pokemontcg.domain

import junit.framework.Assert
import org.hibernate.cfg.Configuration
import org.hibernate.testing.junit4.BaseCoreFunctionalTestCase
import org.hibernate.testing.transaction.TransactionUtil
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import java.io.IOException
import java.util.*

internal class MovementTest : BaseCoreFunctionalTestCase() {

    private val properties: Properties
        @Throws(IOException::class)
        get() {
            val properties = Properties()
            properties.load(javaClass.classLoader.getResourceAsStream("hibernate.properties"))
            return properties
        }

    override fun getAnnotatedClasses(): Array<Class<*>> {
        return arrayOf(Movement::class.java, Type::class.java, EnergyCard::class.java)
    }

    override fun configure(configuration: Configuration) {
        super.configure(configuration)
        configuration.properties = properties
    }

    @Test
    fun givenAMovement_WhenSearchById_ThenReturnTheMovement(){

        TransactionUtil.doInHibernate(({this.sessionFactory()}), {
            session ->
            val electric = Type(1, "Electric")
            session.save(electric)
            val energyCard = EnergyCard(1, electric)
            session.save(energyCard)
            val movement = Movement(1, "Thunder Shock", "A powerful shock", electric, MovementCategory.PHYSICAL, 40, arrayOf(energyCard, energyCard).asList())
            session.save(movement)
            val find = session.find(Movement::class.java, movement.id)
            assertEquals(movement, find)
            assertEquals(MovementCategory.PHYSICAL, find.movementCategory)
            assertEquals(2, find.requiredEnergies.size)
        })

    }

}