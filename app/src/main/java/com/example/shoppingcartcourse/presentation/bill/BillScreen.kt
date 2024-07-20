package com.example.shoppingcartcourse.presentation.bill

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import com.example.shoppingcartcourse.components.CommonTopBar
import com.example.shoppingcartcourse.core.getFormattedPrice
import com.example.shoppingcartcourse.domain.model.CartUiState
import com.example.shoppingcartcourse.navigation.Screen

@Composable
fun BillScreen(
    navController: NavHostController,
    cartUiState: CartUiState,
    resetCart: () -> Unit
) {

    Scaffold(
        topBar = {
            CommonTopBar(
                title = stringResource(id = Screen.Bill.title),
                canNavigateBack = true,
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(
                    rememberScrollState()
                )
        ) {
            Text(
                text = "Items Summary",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Start)
            )

            cartUiState.itemsSelected.forEach {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = it.name,
                        modifier = Modifier.padding(start = 8.dp)
                    )

                    Text(
                        text = it.getFormattedPrice(),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            }

            HorizontalDivider(
                thickness = 4.dp
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "TOTAL",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp)
                )

                Text(
                    text = cartUiState.total.getFormattedPrice(),
                    modifier = Modifier.padding(end = 8.dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                OutlinedButton(
                    onClick = {
                        resetCart()
                        navController.navigate(
                            route = Screen.Home.route,
                            navOptions = NavOptions.Builder()
                                .setPopUpTo(Screen.Home.route, inclusive = false)
                                .build()
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    Text(text = "Cancel")
                }

                Button(
                    onClick = {
                        resetCart()
                        navController.navigate(
                            route = Screen.Home.route,
                            navOptions = NavOptions.Builder()
                                .setPopUpTo(Screen.Home.route, inclusive = true)
                                .build()
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    Text(text = "Submit")
                }

            }

        }
    }


}