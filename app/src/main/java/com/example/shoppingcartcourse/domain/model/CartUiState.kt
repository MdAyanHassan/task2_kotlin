package com.example.shoppingcartcourse.domain.model

data class CartUiState(
    val itemsSelected: List<Item> = emptyList(),
    val total: Float = 0f
)
