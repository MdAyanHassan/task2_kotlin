package com.example.shoppingcartcourse.presentation.fruit

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.shoppingcartcourse.components.CommonTopBar
import com.example.shoppingcartcourse.components.MenuItemsScreen
import com.example.shoppingcartcourse.data.FruitDataSource
import com.example.shoppingcartcourse.domain.model.CartUiState
import com.example.shoppingcartcourse.domain.model.Item
import com.example.shoppingcartcourse.navigation.Screen

@Composable
fun FruitsScreen(
    navController: NavHostController,
    cartUiState: CartUiState,
    resetCart: () -> Unit,
    addItem: (item: Item) -> Unit,
    deleteItem: (item: Item) -> Unit,
) {

    Scaffold(
        topBar = {
            CommonTopBar(
                title = stringResource(id = Screen.Fruit.title),
                canNavigateBack = true,
                onBackClick = {
                    navController.navigate(Screen.Vegetable.route)
                }
            )
        }
    ) { innerPadding ->

        MenuItemsScreen(
            items = FruitDataSource.fruits,
            onNextClick = {
                navController.navigate(Screen.Bill.route)
            },
            onCancelClick = {
                resetCart()
                navController.navigate(Screen.Home.route)
            },
            onItemClick = { item, isChecked ->

                if (isChecked) {
                    addItem(item)
                } else {
                    deleteItem(item)
                }

            },
            cartUiState = cartUiState,
            innerPadding = innerPadding
        )

    }
}