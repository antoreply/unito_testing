package it.reply.iriscube.unito

import org.junit.Assert.assertEquals
import org.junit.Test

class AssertEqualsUnitTest {

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
    fun expensiveCoffeeTest() {
        assertEquals("Cappuccino", coffeeOrder.getMostExpensiveCoffee()?.name)
    }

    @Test
    fun `there are exactly two Decaffeinato in the order`() {
        //TODO
    }

}
