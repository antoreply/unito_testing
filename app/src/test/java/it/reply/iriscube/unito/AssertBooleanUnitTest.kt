package it.reply.iriscube.unito

import org.junit.Assert.assertFalse
import org.junit.Test

class AssertBooleanUnitTest {

    @Test
    fun evenPriceTest() {
        val abut = AssertBooleanUnitTest()
        assertFalse(abut.isPriceEvenNumber(3f))
    }

    @Test
    fun oddNumberTest() {
        // TODO check if the price is even or odd number, using the opposite of the previous example
    }

    private fun isPriceEvenNumber(number: Float): Boolean {
        var result = false
        if (number % 2f == 0f) {
            result = true
        }
        return result
    }
}