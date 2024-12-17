package com.example.dwitchapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
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
    val appBarColor = Color(0xFFFF5722) // Couleur commune pour TopBar et BottomBar

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("              Dwitch App", color = Color.White) },
                navigationIcon = { Text("Menu", color = Color.White, modifier = Modifier.padding(8.dp)) },
                actions = { Text("Profil", color = Color.White, modifier = Modifier.padding(8.dp)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = appBarColor
                )
            )
        },
        content = { innerPadding ->
            // Contenu de la page avec les boutons alignés horizontalement
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FilledButtonExample(text = "Meat", onClick = { /* Action Meat */ })
                    FilledButtonExample(text = "Vegetable", onClick = { /* Action Vegetable */ })
                    FilledButtonExample(text = "Bread", onClick = { /* Action Bread */ })
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                containerColor = appBarColor,
                contentColor = Color.White
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
fun FilledButtonExample(text: String, onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF2243))
    ) {
        Text(text = text, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    DwitchAppTheme {
        MainScreen()
    }
}
