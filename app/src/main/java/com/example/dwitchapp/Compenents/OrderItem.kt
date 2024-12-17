package com.example.dwitchapp.Compenents

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dwitchapp.models.Order
import com.example.dwitchapp.models.Ingredient
import com.example.dwitchapp.models.IngredientType
import com.example.dwitchapp.models.toIngredientType

@Composable
fun OrderItem(order: Order) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Commande #${order.documentID}", style = MaterialTheme.typography.titleMedium)
                Text("Prix : ${order.price}€", color = Color.Gray, fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Text("Progression : ", fontSize = 14.sp)
                LinearProgressIndicator(
                    progress = { (order.progress ?: 0).toFloat() / 100f },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp),
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow {
                items(order.ingredients ?: emptyList()) { ingredient ->
                    IngredientChip(ingredient)
                }
            }
        }
    }
}

@Composable
fun IngredientChip(ingredient: Ingredient) {
    val type = ingredient.kind?.toIngredientType() ?: IngredientType.OTHER
    Row(
        modifier = Modifier
            .padding(end = 8.dp)
            .background(color = type.color, shape = RoundedCornerShape(50))
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(type.emoji, fontSize = 16.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(ingredient.name ?: "Ingrédient", color = Color.White, fontSize = 12.sp)
    }
}
