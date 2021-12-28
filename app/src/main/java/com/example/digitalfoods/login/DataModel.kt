package com.example.digitalfoods

class DataModel(
    val id: Int,
    val nome: String,
    val endereco: String,
    val fechamento: String,
    val urlImg: String,
    var menu: MutableList<MenuModel>
)


class MenuModel(
    val img: String,
    val prato: String,
    val descricao: String,
    val preco: String
)