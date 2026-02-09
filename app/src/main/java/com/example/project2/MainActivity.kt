package com.example.project2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: WishlistAdapter
    private val items = mutableListOf<WishlistItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val nameInput = findViewById<TextInputEditText>(R.id.nameInput)
        val priceInput = findViewById<TextInputEditText>(R.id.priceInput)
        val urlInput = findViewById<TextInputEditText>(R.id.urlInput)
        val addButton = findViewById<Button>(R.id.AddButton)

        adapter = WishlistAdapter(items)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        addButton.setOnClickListener {

            val name = nameInput.text.toString()
            val price = priceInput.text.toString()
            val url = urlInput.text.toString()

            if (name.isNotEmpty() && price.isNotEmpty() && url.isNotEmpty()) {

                items.add(WishlistItem(name, price, url))
                adapter.notifyItemInserted(items.size - 1)

                nameInput.text?.clear()
                priceInput.text?.clear()
                urlInput.text?.clear()

                recyclerView.scrollToPosition(items.size - 1)
            }
        }
    }
}
