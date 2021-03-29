package it.reply.iriscube.unito

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class AssertBooleanUnitTest {

    private lateinit var coffeeOrder: CoffeeOrder

    @Before
    fun setUp() {
        coffeeOrder = CoffeeOrder(
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
    fun `price of original list is odd (9)`() {
        val isEven = coffeeOrder.isTotalPriceEvenNumber()
        assertFalse(isEven)
    }

    @Test
    fun `price of modified list is even (10)`() {
        coffeeOrder.addCoffee(CoffeeType(1, "Espresso", 1.0f))
        val isEven = coffeeOrder.isTotalPriceEvenNumber()
        assertTrue(isEven)
    }

    @Test
    fun `price of modified list is odd (10,5)`() {
        coffeeOrder.addCoffee(CoffeeType(5, "Gingseng", 1.5f))
        val isEven = coffeeOrder.isTotalPriceEvenNumber()
        assertFalse(isEven)
    }

    @Test
    fun `price of modified list is odd (11,5)`() {
        coffeeOrder.addCoffee(CoffeeType(6, "Frappuccino", 2.5f))
        val isEven = coffeeOrder.isTotalPriceEvenNumber()
        assertFalse(isEven)
    }


}