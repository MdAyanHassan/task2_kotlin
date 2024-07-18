package com.example.shoppingcartcourse.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shoppingcartcourse.presentation.CartViewModel
import com.example.shoppingcartcourse.presentation.bill.BillScreen
import com.example.shoppingcartcourse.presentation.fruit.FruitsScreen
import com.example.shoppingcartcourse.presentation.home.HomeScreen
import com.example.shoppingcartcourse.presentation.vegetable.VegetablesScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    cartViewModel: CartViewModel
) {

    val cartUiState by cartViewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {
            HomeScreen(
                onStartClick = {
                    navController.navigate(
                        Screen.Vegetable.route
                    )
                }
            )
        }

        composable(Screen.Vegetable.route) {
            VegetablesScreen(
                navController = navController,
                cartUiState = cartUiState,
                addItem = {
                    cartViewModel.addItem(it)
                },
                deleteItem = {
                    cartViewModel.deleteItem(it)
                },
                resetCart = {
                    cartViewModel.resetCart()
                }
            )
        }

        composable(Screen.Fruit.route) {
            FruitsScreen(
                navController = navController,
                cartUiState = cartUiState,
                addItem = {
                    cartViewModel.addItem(it)
                },
                deleteItem = {
                    cartViewModel.deleteItem(it)
                },
                resetCart = {
                    cartViewModel.resetCart()
                }
            )
        }

        composable(Screen.Bill.route) {
            BillScreen(
                navController = navController,
                cartUiState = cartUiState,
                resetCart = {
                    cartViewModel.resetCart()
                }
            )
        }

    }
}