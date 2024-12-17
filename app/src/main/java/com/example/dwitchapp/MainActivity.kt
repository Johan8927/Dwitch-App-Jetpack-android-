package com.example.dwitchapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.dwitchapp.models.*
import com.example.dwitchapp.ui.theme.DwitchAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DwitchAppTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val appBarColor = Color(0xFFEEDEC8) // Couleur commune pour TopBar et BottomBar

    // Exemple d'Order mock
    val orders = listOf(mockOrder)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dwitch App", color = Color.Black) },
                navigationIcon = { Text("Menu", color = Color.Black, modifier = Modifier.padding(8.dp)) },
                actions = { Text("Profil", color = Color.Black, modifier = Modifier.padding(8.dp)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = appBarColor
                )
            )
        },
        content = { innerPadding ->

            // Contenu de la page
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.TopCenter
            ) {

                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Ingrédients de la commande", style = MaterialTheme.typography.titleLarge)

                    // Affichage des ingrédients
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(orders.flatMap { it.ingredients ?: emptyList() }) { ingredient ->
                            IngredientChip(ingredient)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Affichage des boutons pour les types d'ingrédients
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(1.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IngredientButton(text = "Meat", onClick = { /* Action Meat */ })
                        IngredientButton(text = "Vegetable", onClick = { /* Action Vegetable */ })
                        IngredientButton(text = "Bread", onClick = { /* Action Bread */ })
                        IngredientButton(text = "Dairy", onClick = { /* Action Dairy */ })
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
fun IngredientButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB0EAB9))
    ) {
        Text(text = text, color = Color.Black)
    }
}

@Composable
fun IngredientChip(ingredient: Ingredient) {
    val type = ingredient.kind?.toIngredientType() ?: IngredientType.VEGETABLE // Valeur par défaut
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

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    DwitchAppTheme {
        MainScreen()
    }
}
