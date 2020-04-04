package it.reply.iriscube.unito

class CoffeeOrder {
    var mCoffeePrice: Float = CoffeeType.getMenu()[0].price
    var mCoffeeCount: Int = 0
    var mTotalPrice: Float = 0f

    constructor(coffeePrice: Float){
        mCoffeePrice = coffeePrice
    }

    fun setCoffeeCount(count: Int){
        if(count >= 0)
            mCoffeeCount = count

        calculateTotalPrice()
    }

    fun getCoffeeCount(): Int{
        return mCoffeeCount
    }

    fun incrementCoffeeCount(){
        mCoffeeCount++
        calculateTotalPrice()
    }

    fun decrementCoffeeCount(){
        if(mCoffeeCount > 0) {
            mCoffeeCount--
            calculateTotalPrice()
        }
    }

    fun calculateTotalPrice(){
        mTotalPrice = mCoffeePrice * mCoffeeCount
    }

    fun getTotalPrice(): Float{
        return mTotalPrice
    }

}