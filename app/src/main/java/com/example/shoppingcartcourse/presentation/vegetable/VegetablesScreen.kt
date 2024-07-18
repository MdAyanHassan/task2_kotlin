package com.example.shoppingcartcourse.presentation.vegetable

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.shoppingcartcourse.components.CommonTopBar
import com.example.shoppingcartcourse.components.MenuItemsScreen
import com.example.shoppingcartcourse.data.VegetableDataSource
import com.example.shoppingcartcourse.domain.model.CartUiState
import com.example.shoppingcartcourse.domain.model.Item
import com.example.shoppingcartcourse.navigation.Screen

@Composable
fun VegetablesScreen(
    navController: NavHostController,
    cartUiState: CartUiState,
    addItem: (Item) -> Unit,
    deleteItem: (Item) -> Unit,
    resetCart: () -> Unit
) {

    Scaffold(
        topBar = {
            CommonTopBar(
                title = stringResource(id = Screen.Vegetable.title),
                canNavigateBack = true,
                onBackClick = {
                    navController.navigate(Screen.Home.route)
                }
            )
        }
    ) { innerPadding ->

        MenuItemsScreen(
            items = VegetableDataSource.vegetables,
            onNextClick = {
                navController.navigate(Screen.Fruit.route)
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