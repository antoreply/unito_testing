package it.reply.iriscube.unito

/**
 * Created by Reply on 29/03/2021.
 */

interface BarInterface {
    fun getName(): String
    fun getLocation(): String
}

class Bar constructor(private val name: String, private val location: String) : BarInterface {

    override fun getName(): String {
        return name
    }

    override fun getLocation(): String {
        return location
    }

    companion object {
        fun getMenu(): List<CoffeeType> {
            val coffees = ArrayList<CoffeeType>()
            coffees.add(CoffeeType(1, "Espresso", 1.0f))
            coffees.add(CoffeeType(2, "Cappuccino", 1.4f))
            coffees.add(CoffeeType(3, "Ginseseng", 1.5f))
            coffees.add(CoffeeType(4, "Decaffeinato", 1.1f))
            coffees.add(CoffeeType(5, "Americano", 1.6f))
            coffees.add(CoffeeType(6, "Irish Coffee", 2.0f))
            return coffees
        }
    }
}