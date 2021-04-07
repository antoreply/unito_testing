package it.reply.iriscube.unito

import java.util.*

/**
 * Created by Reply on 4/7/21.
 */
class Waiter(private val name: String, private val bar: BarInterface) {

    fun pleasePay(coffeeOrder: CoffeeOrderInterface): String {
        val total = coffeeOrder.calculateTotalPrice()
        return "The total is $total €. How would you like to pay?"
    }

    fun sayHi(): String {
        return "Hi, my name is $name and i work at ${bar.getName()}"
    }

    fun sayHiAndLocation(): String {
        return "Hi, my name is $name and i work at ${bar.getName()}, which is in ${bar.getLocation()}"
    }

    fun tellCoffeeTypeQuantity(coffeeOrder: CoffeeOrderInterface, coffeeType: CoffeeType): String {
        val q = coffeeOrder.getQuantityOf(coffeeType)
        return "You ordered $q of this coffee type"
    }

}