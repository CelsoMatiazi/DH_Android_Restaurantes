package com.example.digitalfoods.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalfoods.MenuModel
import com.example.digitalfoods.R
import com.squareup.picasso.Picasso
import java.util.*

class MenuAdapter(
    private val menuList: MutableList<MenuModel>,
    val clickListener: (prato: Map<String, Any>) -> Unit):
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_layout, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        Picasso.get()
            .load(menuList[position].img)
            .placeholder(R.color.greyLight2)
            .into((holder.image))

        holder.nome.text = menuList[position].prato
        holder.preco.text = menuList[position].preco

        holder.itemView.setOnClickListener{
            val data : MutableMap<String, Any> = mutableMapOf()
            val rootView = it.findViewById<View>(R.id.card_prato)

            data["nome"] = menuList[position].prato
            data["img"] = menuList[position].img
            data["descricao"] = menuList[position].descricao
            data["preco"] = menuList[position].preco
            data["view"] = rootView

            clickListener.invoke(data)
        }

    }

    override fun getItemCount(): Int = menuList.size

    inner class MenuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var image : ImageView = itemView.findViewById(R.id.menu_img)
        var nome : TextView = itemView.findViewById(R.id.menu_nome)
        var preco : TextView = itemView.findViewById(R.id.menu_price)

    }
}