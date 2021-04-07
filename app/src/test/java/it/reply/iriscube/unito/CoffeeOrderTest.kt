package it.reply.iriscube.unito

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CoffeeOrderTest {

    private lateinit var mOrder: CoffeeOrder

    @Before
    fun setUp() {
        mOrder = CoffeeOrder(
            items = mutableListOf(
                CoffeeType(1, "Espresso", 1.0f),
                CoffeeType(1, "Espresso", 1.0f),
                CoffeeType(2, "Ginseseng", 1.5f),
                CoffeeType(3,"Decaffeinato", 2f),
                CoffeeType(3, "Decaffeinato", 2f),
                CoffeeType(4, "Cappuccino", 1.5f)
            )
        )
    }

    @Test
    fun orderIsNotNull() {
        assertNotNull(mOrder)
    }

    @Test
    fun orderDecrement() {
        assertEquals(6, mOrder.count())
        mOrder.removeCoffee(CoffeeType(1, "Espresso", 1.0f))
        assertEquals(5, mOrder.count())

        mOrder.removeCoffee(CoffeeType(6, "Frappuccino", 2.5f))
        assertEquals(5, mOrder.count())
    }

    @Test
    fun orderIncrement() {
        //TODO (6)
    }

    @Test
    fun `add items and check total`() {
        mOrder.addCoffee(CoffeeType(1, "Espresso", 1.0f))
        assertEquals(10f, mOrder.calculateTotalPrice())

        mOrder.addCoffee(CoffeeType(6, "Frappuccino", 2.5f))
        assertEquals(12.5f, mOrder.calculateTotalPrice())
    }

    @Test
    fun `remove items and check total`() {
        mOrder.removeCoffee(CoffeeType(3, "Decaffeinato", 2f))
        assertEquals(7f, mOrder.calculateTotalPrice())
    }

    @Test
    fun `check coffee with longest name is 'Decaffeinato'`() {
        //TODO (7)
    }
}