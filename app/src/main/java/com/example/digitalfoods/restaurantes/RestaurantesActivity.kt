package com.example.digitalfoods.restaurantes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalfoods.model.MockDataClass
import com.example.digitalfoods.R
import com.example.digitalfoods.menu.RestauranteMenu

import android.app.ActivityOptions
import android.view.View


class RestaurantesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurantes)

        val data = MockDataClass()

        val recyclerViewFeed = findViewById<RecyclerView>(R.id.RV_restaurantes)

        recyclerViewFeed.adapter = RestaurantesAdpter(data.dataList) {
            val intent = Intent(this, RestauranteMenu::class.java)
            intent.putExtra("id", it)

            val sharedView: View = recyclerViewFeed
            val transitionName = getString(R.string.restauranteImageTrans)

            val transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
                this,
                sharedView,
                transitionName
            )
            startActivity(intent, transitionActivityOptions.toBundle())
            //startActivity(intent)

        }
        recyclerViewFeed.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }

}