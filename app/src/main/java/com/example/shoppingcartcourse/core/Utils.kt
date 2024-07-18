package com.example.shoppingcartcourse.core

import java.text.NumberFormat

fun Float.getFormattedPrice(): String {
    return NumberFormat.getCurrencyInstance().format(this)
}