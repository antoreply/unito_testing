package it.reply.iriscube.unito

/**
 * Created by Reply on 29/03/2021.
 */
class Bar constructor(private val name: String, location: String) {

    companion object {
        fun getMenu(): List<CoffeeType> {
            val coffees = ArrayList<CoffeeType>()
            coffees.add(CoffeeType(1, "Espresso", 1.0f))
            coffees.add(CoffeeType(2, "Cappuccino", 1.4f))
            coffees.add(CoffeeType(3, "Ginseseng", 1.5f))
            coffees.add(CoffeeType(4, "Decaffeinato", 1.1f))
            coffees.add(CoffeeType(5, "Americano", 1.6f))
            coffees.add(CoffeeType(6, "Irish Cofee", 2.0f))
            return coffees
        }
    }
}