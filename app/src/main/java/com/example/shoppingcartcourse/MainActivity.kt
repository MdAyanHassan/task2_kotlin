package com.example.shoppingcartcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.shoppingcartcourse.navigation.NavGraph
import com.example.shoppingcartcourse.ui.theme.ShoppingCartCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingCartCourseTheme {
                NavGraph(
                    navController = rememberNavController(), cartViewModel = viewModel()
                )
            }
        }
    }
}