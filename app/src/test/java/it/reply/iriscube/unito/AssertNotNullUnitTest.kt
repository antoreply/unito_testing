package it.reply.iriscube.unito

import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class AssertNotNullUnitTest {

    private lateinit var coffeeOrder: CoffeeOrder

    @Before
    fun setUp() {
        coffeeOrder = CoffeeOrder(mutableListOf())
    }

    @Test
    fun `original coffee order is empty`() {
        val expensiveCoffee = coffeeOrder.getCoffeeWithLongestName()
        assertNull(expensiveCoffee)
    }

    @Test
    fun `add coffees to the order so there is a coffee with longest name`() {
        coffeeOrder.addCoffee(CoffeeType(1, "Espresso", 1.0f))
        val expensiveCoffee = coffeeOrder.getCoffeeWithLongestName()
        assertNotNull(expensiveCoffee)
    }

}
