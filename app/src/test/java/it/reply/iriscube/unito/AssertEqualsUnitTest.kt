package it.reply.iriscube.unito

import org.junit.Assert.assertEquals
import org.junit.Test

class AssertEqualsUnitTest {

    @Test
    fun myStringEqualsTest() {
        val coffee = CoffeeType.getMenu()[4]
        val expectedName = coffee.getExpensiveCoffeeType()

        // assertEquals(expectedName, coffee.getExpensiveCoffeeType())

        // TODO check if the expensive coffeeType is as expected
    }
}
