package it.reply.iriscube.unito

import org.junit.Assert.assertEquals
import org.junit.Test

class AssertEqualsUnitTest {

    @Test
    fun myStringEqualsTest() {
        val coffee = CoffeeType(5, "Americano", 1.6f)
        val expectedName = "Americano"

        assertEquals(expectedName, coffee.getExpensiveCoffeeType())
    }
}
