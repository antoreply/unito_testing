package it.reply.iriscube.unito

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    val espressoDoppio = CoffeeType(id = 6, name = "EspressoDoppio", price = 1.7f)

    private var mOrder: CoffeeOrder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coffeePrice.text = String.format(getString(R.string.coffee_price), espressoDoppio.name, espressoDoppio.price)
        totalPrice.text = String.format(getString(R.string.total_price), 0.0f)

        coffeeIncrement.setOnClickListener(this)
        coffeeDecrement.setOnClickListener(this)

        mOrder = CoffeeOrder(
            items = mutableListOf()
        )
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.coffeeIncrement -> {
                //mOrder?.incrementCoffeeCount()
                updateCoffeeCount()
                updateTotalPrice()
            }
            R.id.coffeeDecrement -> {
                //mOrder?.decrementCoffeeCount()
                updateCoffeeCount()
                updateTotalPrice()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mOrder?.let {order ->
            //outState.putInt(COFFEE_COUNT, order.getCoffeeCount())
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        savedInstanceState?.let {
            //mOrder!!.setCoffeeCount(savedInstanceState.getInt(COFFEE_COUNT))
            updateCoffeeCount()
            updateTotalPrice()
        }
    }

    private fun updateCoffeeCount() {
        //coffeeCount.text = mOrder?.getCoffeeCount().toString()
    }

    private fun updateTotalPrice() {
        //totalPrice.text = String.format(getString(R.string.total_price), mOrder?.totalPrice)
    }


}
