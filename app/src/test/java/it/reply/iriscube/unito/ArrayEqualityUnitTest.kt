package it.reply.iriscube.unito

import org.junit.Assert.assertArrayEquals
import org.junit.Before
import org.junit.Test


class ArrayEqualityUnitTest {

    private lateinit var expectedCoffee: Array<CoffeeType>

    @Before
    fun initInputs() {
        expectedCoffee = arrayOf(
            CoffeeType(1, "Espresso", 1f),
            CoffeeType(2, "Cappuccino", 1.4f),
            CoffeeType(3, "Ginseseng", 1.5f),
            CoffeeType(4, "Decaffeinato", 1.1f),
            CoffeeType(5, "Americano", 1.6f)
        )
    }

    @Test
    fun compareEmployees() {
        /**
         * convert List of objects to array of objects
         */

        val testOutput = CoffeeType.getMenu().toTypedArray()
        assertArrayEquals(expectedCoffee, testOutput)
    }

}