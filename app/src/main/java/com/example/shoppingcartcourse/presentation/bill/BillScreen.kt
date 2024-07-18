package com.example.shoppingcartcourse.presentation.bill

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
                    navController.navigate(Screen.Fruit.route)
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
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
                    Text(text = it.name)

                    Text(text = it.getFormattedPrice())
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
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = cartUiState.total.getFormattedPrice()
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
                        navController.navigate(Screen.Home.route)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Cancel")
                }

                Button(
                    onClick = {
                        resetCart()
                        navController.navigate(Screen.Home.route)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Submit")
                }

            }

        }
    }


}