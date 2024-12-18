package com.example.dwitchapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dwitchapp.models.*
import com.example.dwitchapp.ui.theme.DwitchAppTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val appBarColor = Color(0xFFEEDEC8) // Couleur commune pour TopBar et BottomBar

    // Utilisation de mockOrders pour afficher les commandes et les ingrédients
    val orders = mockOrders // Remplacer par les mockOrders simulées

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("            Dwitch App", color = Color.Black) },
                navigationIcon = { Text("Menu", color = Color.Black, modifier = Modifier.padding(8.dp)) },
                actions = { Text("Profil", color = Color.Black, modifier = Modifier.padding(8.dp)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = appBarColor
                )
            )
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Commandes", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(16.dp))

                    // Affichage des commandes et des dates
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(orders) { order ->
                            OrderItem(order)
                        }
                    }
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                containerColor = appBarColor,
                contentColor = Color.Black
            ) {
                Text("Accueil", modifier = Modifier.padding(8.dp))
                Spacer(modifier = Modifier.weight(1f))
                Text("Commandes", modifier = Modifier.padding(8.dp))
                Spacer(modifier = Modifier.weight(1f))
                Text("Profil", modifier = Modifier.padding(8.dp))
            }
        }
    )
}

@Composable
fun OrderItem(order: Order) {
    // Formatage de la date
    val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm")
    val formattedDate = order.date.format(formatter) ?: "Date inconnue"

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFE0F7FA), shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text("Commande n°${order.id}", color = Color.Black, fontSize = 16.sp)
        Text("Date : $formattedDate", color = Color.Gray, fontSize = 14.sp)

        Spacer(modifier = Modifier.height(8.dp))

        Text("Ingrédients :", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(4.dp))

        // Affichage des ingrédients
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(order.ingredients ?: emptyList()) { ingredient ->
                IngredientChip(ingredient)
            }
        }
        // Ajout d'un espacement sous les ingrédients
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
fun IngredientChip(ingredient: Ingredient) {
    val type = ingredient.kind?.toIngredientType() ?: IngredientType.VEGETABLE

    Row(
        modifier = Modifier
            .padding(end = 8.dp)
            .background(color = type.color, shape = RoundedCornerShape(50))
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(type.emoji, fontSize = 16.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(ingredient.name ?: "Ingrédient", color = Color.White, fontSize = 14.sp)

    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    DwitchAppTheme {
        MainScreen()
    }
}


