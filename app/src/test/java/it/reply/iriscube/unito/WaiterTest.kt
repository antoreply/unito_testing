package it.reply.iriscube.unito

import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito

/**
 * Created by Reply on 4/7/21.
 */
class WaiterTest {

    private val coffeeOrder = Mockito.mock(CoffeeOrderInterface::class.java)
    private val bar = Mockito.mock(BarInterface::class.java)
    private val waiter = Waiter(
        name = "Mark",
        bar = bar
    )

    @Test
    fun pleasePay() {
        Mockito.`when`(coffeeOrder.calculateTotalPrice()).thenReturn(20f)

        val result = waiter.pleasePay(coffeeOrder)
        assertEquals(
            "The total is 20.0 €. How would you like to pay?",
            result
        )
    }

    @Test
    fun sayHi() {
        Mockito.`when`(bar.getName()).thenReturn("My Bar")

        val result = waiter.sayHi()
        assertEquals(
            "Hi, my name is Mark and i work at My Bar",
            result
        )
    }

    @Test
    fun tellCoffeeTypeQuantity() {
        Mockito.`when`(coffeeOrder.getQuantityOf(
            MockitoHelper.anyObject()
        )).thenReturn(3)
        val coffeeType = CoffeeType(4, "Cappuccino", 1.5f)

        val result = waiter.tellCoffeeTypeQuantity(coffeeOrder, coffeeType)
        assertEquals(
            "You ordered 3 of this coffee type",
            result
        )
    }

    @Test
    fun sayHiAndLocation() {
        //TODO (8)
    }
}

object MockitoHelper {
    fun <T> anyObject(): T {
        Mockito.any<T>()
        return uninitialized()
    }
    @Suppress("UNCHECKED_CAST")
    fun <T> uninitialized(): T =  null as T
}