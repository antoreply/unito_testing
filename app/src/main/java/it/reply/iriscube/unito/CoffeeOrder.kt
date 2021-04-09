package it.reply.iriscube.unito

interface CoffeeOrderInterface {
    fun addCoffee(coffee: CoffeeType)
    fun removeCoffee(coffee: CoffeeType)
    fun count(): Int
    fun calculateTotalPrice(): Float
    fun getQuantityOf(coffee: CoffeeType): Int
    fun isTotalPriceEvenNumber(): Boolean
    fun getMostExpensiveCoffee(): CoffeeType?
    fun getCoffeeWithLongestName(): CoffeeType?
}

class CoffeeOrder constructor(private val items: MutableList<CoffeeType>) : CoffeeOrderInterface {

    override fun addCoffee(coffee: CoffeeType) {
        items.add(coffee)
    }

    override fun removeCoffee(coffee: CoffeeType) {
        val itemToRemove = items.firstOrNull { it.id == coffee.id }
        itemToRemove?.let {
            items.remove(it)
        }
    }

    override fun count(): Int {
        return  items.size
    }

    override fun calculateTotalPrice(): Float {
        return items.map { it.price }.sum()
    }

    override fun getQuantityOf(coffee: CoffeeType): Int {
        return items.filter { it.id == coffee.id }.count()
    }

    override fun isTotalPriceEvenNumber(): Boolean {
        var result = false
        if (calculateTotalPrice() % 2 == 0f) {
            result = true
        }
        return result
    }

    override fun getMostExpensiveCoffee(): CoffeeType? {
        return items.maxBy { it.price }
    }

    override fun getCoffeeWithLongestName(): CoffeeType? {
        return items.maxBy { it.name.length }
    }
}