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

class MenuAdapter(
    private val menuList: MutableList<MenuModel>,
    val clickListener: (prato: Map<String, String> ) -> Unit):
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.menu_layout, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        Picasso.get()
            .load(menuList[position].img)
            .placeholder(R.drawable.ic_launcher_background)
            .into((holder.image))

        holder.nome.text = menuList[position].prato

        holder.itemView.setOnClickListener{
            var data : MutableMap<String,String> = mutableMapOf()

            data.put("nome", menuList[position].prato)
            data.put("img", menuList[position].img)
            data.put("descricao", menuList[position].descricao)

            clickListener(data)
        }

    }



    override fun getItemCount(): Int = menuList.size


    inner class MenuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var image : ImageView = itemView.findViewById(R.id.menu_img)
        var nome : TextView = itemView.findViewById(R.id.menu_nome)

    }
}