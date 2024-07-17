package com.example.shoppingcartcourse.navigation

import androidx.annotation.StringRes
import com.example.shoppingcartcourse.R
import com.example.shoppingcartcourse.core.BILLS_ROUTE
import com.example.shoppingcartcourse.core.FRUITS_ROUTE
import com.example.shoppingcartcourse.core.HOME_ROUTE
import com.example.shoppingcartcourse.core.VEGETABLES_ROUTE

sealed class Screen(
    val route: String,
    @StringRes val title: Int
) {
    data object Home: Screen(HOME_ROUTE, R.string.home)
    data object Vegetable: Screen(VEGETABLES_ROUTE, R.string.vegetables)
    data object Fruit: Screen(FRUITS_ROUTE, R.string.fruits)
    data object Bill: Screen(BILLS_ROUTE, R.string.bill)
}
