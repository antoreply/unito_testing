package it.reply.iriscube.unito

class CoffeeOrder constructor(private val items: MutableList<CoffeeType>) {

    fun addCoffee(coffee: CoffeeType) {
        items.add(coffee)
    }

    fun calculateTotalPrice(): Float {
        return items.map { it.price }.sum()
    }

    fun getQuantityOf(coffee: CoffeeType): Int {
        return items.filter { it.id == coffee.id }.count()
    }

    fun removeCoffee(coffee: CoffeeType) {
        val itemToRemove = items.firstOrNull { it.id == coffee.id }
        itemToRemove?.let {
            items.remove(it)
        }
    }

    fun isTotalPriceEvenNumber(): Boolean {
        var result = false
        if (calculateTotalPrice() % 2f == 0f) {
            result = true
        }
        return result
    }

    fun getMostExpensiveCoffee(): CoffeeType? {
        //TODO implement logic
        return CoffeeType(2, "Ginseseng", 1.5f)
    }
}