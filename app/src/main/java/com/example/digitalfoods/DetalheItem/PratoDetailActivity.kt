package com.example.digitalfoods.DetalheItem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.digitalfoods.R
import com.squareup.picasso.Picasso

class PratoDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prato_detail)
        this.supportActionBar?.hide()

        val extras: Bundle? = intent.extras
        val nome: String? = extras?.getString("nome")
        val img: String? = extras?.getString("img")
        val descricao: String? = extras?.getString("descricao")

        val imgPrato = findViewById<ImageView>(R.id.detail_img)
        val nomePrato = findViewById<TextView>(R.id.detail_nome)
        val descricaoPrato = findViewById<TextView>(R.id.detail_descricao)
        val backPrato = findViewById<ImageView>(R.id.detail_back)

        nomePrato.text = nome
        descricaoPrato.text = descricao

        Picasso.get().load(img)
            .fit().centerCrop()
            .into(imgPrato)

        backPrato.setOnClickListener {
            this.finish()
        }
    }

}