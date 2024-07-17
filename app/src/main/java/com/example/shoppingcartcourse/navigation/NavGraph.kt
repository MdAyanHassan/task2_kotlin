package com.example.shoppingcartcourse.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {

        }

        composable(Screen.Vegetable.route) {

        }

        composable(Screen.Fruit.route) {

        }

        composable(Screen.Bill.route) {

        }

    }
}