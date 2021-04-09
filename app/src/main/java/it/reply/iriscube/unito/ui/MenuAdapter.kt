package it.reply.iriscube.unito.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import it.reply.iriscube.unito.CoffeeType
import it.reply.iriscube.unito.R


interface ItemCountListener {
    fun increment(coffeeType: CoffeeType)
    fun decrement(coffeeType: CoffeeType)
}

class MenuAdapter constructor(private val itemCountListener: ItemCountListener) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private var items: List<CoffeeType> = listOf()

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)
        return MenuViewHolder(view)
    }

    @SuppressLint("DefaultLocale")
    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        items[position].let { coffee ->
            holder.nameTextView.text = coffee.name.capitalize()
            holder.priceTextView.text =  "${coffee.price} €"

            holder.decrementButton.setOnClickListener {
                var quantity = holder.quantityTextView.text.toString().toInt()
                if (quantity > 0) {
                    quantity --
                    holder.quantityTextView.text = quantity.toString()
                    itemCountListener.decrement(coffee)
                }
            }

            holder.incrementButton.setOnClickListener {
                var quantity = holder.quantityTextView.text.toString().toInt()
                if (quantity < 10) {
                    quantity ++
                    holder.quantityTextView.text = quantity.toString()
                    itemCountListener.increment(coffee)
                }
            }
        }
    }

    fun updateAll(newItems: List<CoffeeType>) {
        items = newItems
        notifyDataSetChanged()
    }

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name)
        val priceTextView: TextView = itemView.findViewById(R.id.price)
        val decrementButton: Button = itemView.findViewById(R.id.coffeeDecrement)
        val incrementButton: Button = itemView.findViewById(R.id.coffeeIncrement)
        val quantityTextView: TextView = itemView.findViewById(R.id.coffeeCount)

    }
}