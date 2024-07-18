package com.example.shoppingcartcourse.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shoppingcartcourse.domain.model.CartUiState
import com.example.shoppingcartcourse.domain.model.Item

@Composable
fun MenuItemsScreen(
    items: List<Item>,
    onNextClick: () -> Unit,
    onCancelClick: () -> Unit,
    onItemClick: (Item, Boolean) -> Unit,
    cartUiState: CartUiState,
    innerPadding: PaddingValues
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(innerPadding)
            .verticalScroll(
                rememberScrollState()
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items.forEach {
            MenuItem(
                item = it,
                onItemClick = { item, isChecked ->
                    onItemClick(item, isChecked)
                },
                cartUiState = cartUiState
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            OutlinedButton(
                onClick = { onCancelClick() },
                modifier = Modifier.weight(1f)
                    .padding(8.dp)
            ) {
                Text(text = "Cancel")
            }

            Button(
                onClick = { onNextClick() },
                modifier = Modifier.weight(1f)
                    .padding(8.dp)
            ) {
                Text(text = "Next")
            }

        }
    }
}
@Composable
fun MenuItem(
    item: Item,
    onItemClick: (Item, Boolean) -> Unit,
    cartUiState: CartUiState
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = cartUiState.itemsSelected.contains(item),
            onCheckedChange = {
                onItemClick(item, it)
            }
        )

        Text(
            text = item.name,
            modifier = Modifier.padding(
                start = 8.dp
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = item.getFormattedPrice(),
            modifier = Modifier.padding(
                end = 8.dp
            )
        )

    }
}