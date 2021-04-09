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

    //TODO (4) this test fails. Understand why and fix. Tip: unit test is right. Implement getMostExpensiveCoffee properly.
    @Test
    fun expensiveCoffeeTest() {
        assertEquals("Decaffeinato", coffeeOrder.getMostExpensiveCoffee()?.name)
    }

    @Test
    fun `there are exactly two Decaffeinato in the coffee order`() {
        //TODO(5)
    }

}
