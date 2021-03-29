package it.reply.iriscube.unito



import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class CoffeeOrderTest {
    private var mOrder: CoffeeOrder? = null

    @Before
    fun setUp() {
    }

    @Test
    fun orderIsNotNull() {
        assertNotNull(mOrder)
    }
/*
    @Test
    fun orderDecrement() {
        mOrder?.let { order ->
            order.decrementCoffeeCount()
            assertEquals(0, order.getCoffeeCount())

            order.setCoffeeCount(9)
            order.decrementCoffeeCount()
            assertEquals(8, order.getCoffeeCount())
        }
    }*/

/*    @Test
    fun orderIncrement() {
        mOrder?.let { order ->
            order.incrementCoffeeCount()
            assertEquals(1, order.getCoffeeCount())

            order.setCoffeeCount(3)
            order.incrementCoffeeCount()
            assertEquals(4, order.getCoffeeCount())
        }
    }

    @Test
    fun orderTotalPrice() {
        mOrder?.let { order ->
            assertEquals(0.0f, order.totalPrice)

            val nCoffeeOrdered = 6
            order.setCoffeeCount(nCoffeeOrdered)
            assertEquals(PRICE_TEST * nCoffeeOrdered, order.totalPrice)
        }
    }

    @Test
    fun orderSetCoffeeCount() {
        mOrder?.let { order ->
            order.setCoffeeCount(-1)
            assertEquals(0, order.getCoffeeCount())

            order.setCoffeeCount(8)
            assertEquals(8, order.getCoffeeCount())
        }

    }*/
}