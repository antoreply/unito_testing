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
                CoffeeType(2, "Ginseng", 1.5f),
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

    //TODO (2) this test fails. Understand why and fix. Tip: decimal numbers are not even. Check isTotalPriceEvenNumber.
    // --> in isTotalPriceEvenNumber don't cast calculateTotalPrice() to int.
    @Test
    fun `price of modified list is odd (10,5)`() {
        coffeeOrder.addCoffee(CoffeeType(5, "Ginseng", 1.5f))
        val isEven = coffeeOrder.isTotalPriceEvenNumber()
        assertFalse(isEven)
    }

    @Test
    fun `price of modified list is odd (11,5)`() {
        coffeeOrder.addCoffee(CoffeeType(6, "Frappuccino", 2.5f))
        val isEven = coffeeOrder.isTotalPriceEvenNumber()
        assertFalse(isEven)
    }

    @Test
    fun `there are exactly two Espresso in the original list`() {
        //TODO (3)
        val nEspresso = coffeeOrder.getQuantityOf(CoffeeType(1, "Espresso", 1.0f))
        val flag: Boolean = 2 == nEspresso
        assertTrue(flag)
    }


}