package it.reply.iriscube.unito

data class CoffeeOrder(var price: Float = 1.0f, var count: Int = 0, var totalPrice: Float = 0f) {

    fun getCoffeeCount(): Int{
        return count
    }

    fun setCoffeeCount(count: Int){
        if(count >= 0)
            this.count = count

        calculateTotalPrice()
    }

    fun incrementCoffeeCount(){
        count++
        calculateTotalPrice()
    }

    fun decrementCoffeeCount(){
        if(count > 0) {
            count--
            calculateTotalPrice()
        }
    }

    fun calculateTotalPrice(){
        totalPrice = price * count
    }

}