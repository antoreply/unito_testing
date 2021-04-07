package it.reply.iriscube.unito

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import it.reply.iriscube.unito.ui.ItemCountListener
import it.reply.iriscube.unito.ui.MenuAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var mOrder: CoffeeOrder? = null

    private val mAdapter = MenuAdapter(
        object : ItemCountListener {
            override fun increment(coffeeType: CoffeeType) {
                mOrder?.addCoffee(coffeeType)
                updateBill()
            }

            override fun decrement(coffeeType: CoffeeType) {
                mOrder?.removeCoffee(coffeeType)
                updateBill()
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mOrder = CoffeeOrder(
            items = mutableListOf()
        )

        mAdapter.updateAll(Bar.getMenu())

        val layoutManager = LinearLayoutManager(this)
        orderRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                layoutManager.orientation
            )
        )
        orderRecyclerView.layoutManager = layoutManager
        orderRecyclerView.adapter = mAdapter

        updateBill()
    }

    private fun updateBill() {
        val total = mOrder?.calculateTotalPrice()
        billTextView.text = String.format(getString(R.string.bill), total)
    }
}
