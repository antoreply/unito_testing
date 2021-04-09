package it.reply.iriscube.unito

import it.reply.iriscube.unito.Bar.Companion.getMenu
import org.junit.Assert.*
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
            CoffeeType(5, "Americano", 1.6f),
            CoffeeType(6, "Irish Coffee", 2.0f)
        )
    }

    @Test
    fun compareObjectsContents() {
        val testOutput = getMenu().toTypedArray()
        assertArrayEquals(expectedCoffee, testOutput)
    }

    //TODO (1) this test fails. Understand why and fix.
    // --> object references are different.
    @Test
    fun compareObjectReferences() {
        val testOutput = getMenu().toTypedArray()
        assertNotSame(expectedCoffee, testOutput)
    }

}