package it.reply.iriscube.unito

data class CoffeeType(var id: Int, var name: String, var price: Float) {

    companion object {
        fun getMenu(): List<CoffeeType> {
            val coffees = ArrayList<CoffeeType>()
            coffees.add(CoffeeType(1, "Espresso", 1.0f))
            coffees.add(CoffeeType(2, "Cappuccino", 1.4f))
            coffees.add(CoffeeType(3, "Ginseseng", 1.5f))
            coffees.add(CoffeeType(4, "Decaffeinato", 1.1f))
            coffees.add(CoffeeType(5, "Americano", 1.6f))
            return coffees
        }
    }

    fun getExpensiveCoffeeType(): String {
        /**
         * logic to get Highest paid employee
         */
        return "Americano"
    }

}