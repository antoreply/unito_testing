package it.reply.iriscube.unito

import org.junit.Assert.assertNotNull
import org.junit.Test

class AssertNotNullUnitTest {

    @Test
    fun notNullTest() {
        // assertNotNull(getPropValue(1.4f))

        // TODO check if exist a not null coffeeType with price 1.1f and is

    }

    private fun getPropValue(key: Float): String? {
        val appProps = mapOf(
            1f to "Espresso",
            1.4f to "Cappuccino",
            1.1f to "Decaffeinato"
        )
        return appProps[key]
    }
}
