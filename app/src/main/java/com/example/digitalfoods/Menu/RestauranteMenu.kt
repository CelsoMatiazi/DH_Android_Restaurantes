package com.example.digitalfoods.Menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalfoods.*
import com.example.digitalfoods.DetalheItem.PratoDetailActivity
import com.example.digitalfoods.Model.MockDataClass
import com.squareup.picasso.Picasso


class RestauranteMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante_menu)

        this.supportActionBar?.hide()

        val data = MockDataClass()
        val extras: Bundle? = intent.extras
        val id: Int? = extras?.getInt("id")

        val itemData : DataModel = data.getRestaurant(id ?: 1)

        val imgRest = findViewById<ImageView>(R.id.rest_menu_img)
        val nomeRest = findViewById<TextView>(R.id.rest_menu_nome)
        val backRest = findViewById<ImageView>(R.id.rest_menu_back)


        val recyclerViewMenu = findViewById<RecyclerView>(R.id.rest_menu_RV)

        recyclerViewMenu.adapter = MenuAdapter(itemData.menu){
            val intent = Intent(this, PratoDetailActivity::class.java)
            intent.putExtra("nome", it["nome"])
            intent.putExtra("img", it["img"])
            intent.putExtra("descricao", it["descricao"])
            startActivity(intent)
        }
        recyclerViewMenu.layoutManager = GridLayoutManager(this,2, GridLayoutManager.VERTICAL, false)


        nomeRest.text = itemData.nome

        Picasso.get().load(itemData.urlImg)
            .fit().centerCrop()
            .into(imgRest)

        backRest.setOnClickListener {
            this.finish()
        }
    }
}