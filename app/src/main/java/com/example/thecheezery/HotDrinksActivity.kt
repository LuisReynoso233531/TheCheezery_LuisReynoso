package com.example.thecheezery

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HotDrinksActivity : AppCompatActivity() {

    var hotDrinks = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hot_drinks)
        agregaProductos()

        val listView: ListView = findViewById(R.id.hotDrinks)
        val adaptador = AdaptadorProductos(this, hotDrinks)
        listView.adapter = adaptador
    }

    fun agregaProductos() {
        hotDrinks.add(Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6.0))
        hotDrinks.add(Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5.0))
        hotDrinks.add(Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4.0))
        hotDrinks.add(Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6.0))
        hotDrinks.add(Product("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7.0))
        hotDrinks.add(Product("American coffee", R.drawable.americano, "Espresso with hot water", 2.0))
    }

    private class AdaptadorProductos(val contexto: Context, val productos: ArrayList<Product>) : BaseAdapter() {
        override fun getCount(): Int = productos.size

        override fun getItem(position: Int): Any = productos[position]

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val prod = productos[position]
            val inflador = LayoutInflater.from(contexto)
            val vista = inflador.inflate(R.layout.producto_view, null)

            val imagen = vista.findViewById<ImageView>(R.id.producto_img)
            val nombre = vista.findViewById<TextView>(R.id.producto_nombre)
            val desc = vista.findViewById<TextView>(R.id.producto_desc)
            val precio = vista.findViewById<TextView>(R.id.producto_precio)

            imagen.setImageResource(prod.image)
            nombre.text = prod.name
            desc.text = prod.description
            precio.text = "$${prod.price}"

            return vista
        }
    }
}
