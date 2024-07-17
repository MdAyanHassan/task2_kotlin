package com.example.shoppingcartcourse.presentation

import androidx.lifecycle.ViewModel
import com.example.shoppingcartcourse.domain.model.CartUiState
import com.example.shoppingcartcourse.domain.model.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CartViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(CartUiState())
    val uiState = _uiState.asStateFlow()

    fun addItem(item: Item) {
        _uiState.update {
            it.copy(
                itemsSelected = it.itemsSelected + item,
                total = it.total + item.price
            )
        }
    }

    fun deleteItem(item: Item) {
        _uiState.update {
            it.copy(
                itemsSelected = it.itemsSelected - item,
                total = it.total - item.price
            )
        }
    }

    fun resetCart() {
        _uiState.value = CartUiState()
    }
}
