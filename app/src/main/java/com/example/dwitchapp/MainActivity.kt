package com.example.dwitchapp

import OrderItem
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dwitchapp.models.*
import com.example.dwitchapp.ui.theme.DwitchAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val appBarColor = Color(0xFFEEDEC8) // Couleur commune pour TopBar et BottomBar

    // Utilisation de mockOrders pour afficher les commandes et les ingrédients
    val orders = mockOrders // Remplacer par les mockOrders simulées

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dwitch App", color = Color.Black) },
                modifier = Modifier.padding(5.dp),
                navigationIcon = {
                    Text(
                        "Menu",
                        color = Color.Black,
                        modifier = Modifier.padding(20.dp)
                    )
                },
                actions = {
                    Text(
                        "Profil",
                        color = Color.Black,
                        modifier = Modifier.padding(20.dp)
                    )

                },
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
                modifier = Modifier.padding(5.dp),
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

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    DwitchAppTheme {
        MainScreen()
    }
}


