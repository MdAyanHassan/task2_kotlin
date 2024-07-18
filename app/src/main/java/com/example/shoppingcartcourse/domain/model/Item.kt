package com.example.shoppingcartcourse.domain.model

import java.text.NumberFormat

data class Item(
    val name: String,
    val price: Float
) {
    fun getFormattedPrice(): String = NumberFormat.getCurrencyInstance().format(price)
}