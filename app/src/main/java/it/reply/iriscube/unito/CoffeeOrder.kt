package it.reply.iriscube.unito

class CoffeeOrder constructor(private val items: MutableList<CoffeeType>) {

    fun addCoffee(coffee: CoffeeType) {
        items.add(coffee)
    }

    fun removeCoffee(coffee: CoffeeType) {
        val itemToRemove = items.firstOrNull { it.id == coffee.id }
        itemToRemove?.let {
            items.remove(it)
        }
    }

    fun count(): Int {
        return  items.size
    }

    fun calculateTotalPrice(): Float {
        return items.map { it.price }.sum()
    }

    fun getQuantityOf(coffee: CoffeeType): Int {
        return items.filter { it.id == coffee.id }.count()
    }

    fun isTotalPriceEvenNumber(): Boolean {
        var result = false
        if (calculateTotalPrice().toInt() % 2 == 0) {
            result = true
        }
        return result
    }

    fun getMostExpensiveCoffee(): CoffeeType? {
        //TODO implement logic
        return CoffeeType(2, "Gingseng", 1.5f)
    }

    fun getCoffeeWithLongestName(): CoffeeType? {
        return items.maxBy { it.name.length }
    }
}