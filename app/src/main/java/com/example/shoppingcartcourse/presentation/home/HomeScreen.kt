package com.example.shoppingcartcourse.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shoppingcartcourse.components.CommonTopBar
import com.example.shoppingcartcourse.navigation.Screen
import com.example.shoppingcartcourse.R

@Composable
fun HomeScreen(
   onStartClick: () -> Unit
) {
    Scaffold(
        topBar = {
            CommonTopBar(
                title = stringResource(id = Screen.Home.title),
                canNavigateBack = false,
                onBackClick = {}
            )
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { onStartClick() },
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = stringResource(id = R.string.start))
            }
        }
    }
}