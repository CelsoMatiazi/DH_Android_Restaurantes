package com.example.digitalfoods.Restaurantes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalfoods.Model.MockDataClass
import com.example.digitalfoods.R
import com.example.digitalfoods.Menu.RestauranteMenu

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