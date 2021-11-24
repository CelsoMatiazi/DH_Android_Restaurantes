package com.example.digitalfoods.restaurantes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalfoods.DataModel
import com.example.digitalfoods.R
import com.squareup.picasso.Picasso

class RestaurantesAdpter(
    val restaurantes: MutableList<DataModel>, val clickListener: (Int) -> Unit):
    RecyclerView.Adapter<RestaurantesAdpter.RestaurantesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurantes_layout, parent, false)

        return RestaurantesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantesViewHolder, position: Int) {
        Picasso.get()
            .load(restaurantes[position].urlImg)
            .placeholder(R.drawable.ic_launcher_background)
            .into((holder.image))

        holder.nome.text = restaurantes[position].nome
        holder.endereco.text = restaurantes[position].endereco
        holder.hora.text = "Fecha " + restaurantes[position].fechamento

        holder.itemView.setOnClickListener{
            clickListener(restaurantes[position].id)
        }
    }

    override fun getItemCount(): Int = restaurantes.size

    inner class RestaurantesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var image : ImageView = itemView.findViewById(R.id.restauranteImg)
        var nome : TextView = itemView.findViewById(R.id.restauranteNome)
        var endereco : TextView = itemView.findViewById(R.id.restauranteEnd)
        var hora : TextView = itemView.findViewById(R.id.restauranteHora)
    }

}