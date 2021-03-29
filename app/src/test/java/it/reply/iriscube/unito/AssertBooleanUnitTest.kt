package it.reply.iriscube.unito

import org.junit.Assert.assertFalse
import org.junit.Test

class AssertBooleanUnitTest {

    private val coffeeOrder = CoffeeOrder(
        items = mutableListOf(
            CoffeeType(1, "Espresso", 1.0f),
            CoffeeType(1, "Espresso", 1.0f),
            CoffeeType(2, "Ginseseng", 1.5f),
            CoffeeType(3,"Decaffeinato", 2f),
            CoffeeType(3, "Decaffeinato", 2f),
            CoffeeType(4, "Cappuccino", 1.5f)
        )
    )

    @Test
    fun evenPriceTest() {
        val isEven = coffeeOrder.isTotalPriceEvenNumber()
        assertFalse(isEven)
    }

    @Test
    fun oddNumberTest() {
        // TODO check if the price is even or odd number, using the opposite of the previous example
    }


}