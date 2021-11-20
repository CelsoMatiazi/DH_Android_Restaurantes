package com.example.digitalfoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RestaurantesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurantes)

        val data = MockDataClass()

        val recyclerViewFeed = findViewById<RecyclerView>(R.id.RV_restaurantes)

        recyclerViewFeed.adapter = RestaurantesAdpter(data.dataList) {
            val intent = Intent(this, RestauranteMenu::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }
        recyclerViewFeed.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }

}