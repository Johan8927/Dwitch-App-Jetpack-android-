package com.example.dwitchapp.Compenents

import OrderItem
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.dwitchapp.models.Order

@Composable
fun OrderList(orders: List<Order>) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(8.dp)) {
        items(orders) { order ->
            OrderItem(order = order)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
