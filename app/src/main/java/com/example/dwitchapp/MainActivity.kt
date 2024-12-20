package com.example.dwitchapp
// Déclare le package de l'application, utilisé pour organiser les fichiers du projet.

import OrderItem
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
// Importe la fonction ou composable `OrderItem` (présumée être définie ailleurs dans le projet).

// Importations des bibliothèques Jetpack Compose pour la mise en page, les composants d'interface utilisateur et les thèmes.
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dwitchapp.Compenents.ProgressIndicator
import com.example.dwitchapp.models.mockOrders
// Importe les données simulées des commandes depuis le package `models`.

import com.example.dwitchapp.ui.theme.DwitchAppTheme
// Importe le thème de l'application défini dans le package `ui.theme`.

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DwitchAppTheme { // Applique le thème de l'application
                MainScreen() // Affiche le composable `MainScreen`
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
// Permet d'utiliser des API expérimentales de Material3.
@Composable
fun MainScreen() {
    val appBarColor = Color(0xFFEEDEC8) // Déclare une couleur personnalisée pour les barres supérieure et inférieure.

    // Utilisation de données simulées pour les commandes.
    val orders = mockOrders // Charge la liste des commandes simulées.

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    // Combinaison d'une icône et d'un texte pour le titre.
                    androidx.compose.foundation.layout.Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            // Charge l'icône `ic_launcher_foreground` depuis les ressources.
                            contentDescription = "Logo Dwitch App", // Description pour l'accessibilité.
                            modifier = Modifier.padding(end = 8.dp), // Ajoute un espace après l'image.
                            contentScale = ContentScale.Fit // Ajuste l'image pour qu'elle conserve ses proportions.
                        )
                        Text("Dwitch App", color = Color.Black)
                        // Affiche le titre de l'application.
                    }
                },
                modifier = Modifier.padding(5.dp), // Ajoute une marge autour de la barre supérieure.
                navigationIcon = {
                    Text(
                        "Menu",
                        color = Color.Black,
                        modifier = Modifier.padding(20.dp) // Ajoute une marge pour le bouton Menu.
                    )
                },
                actions = {
                    Text(
                        "Profil",
                        color = Color.Black,
                        modifier = Modifier.padding(20.dp) // Ajoute une marge pour le bouton Profil.
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = appBarColor // Applique la couleur personnalisée à la barre supérieure.
                )
            )
        },
        content = { innerPadding ->
            // Commandes
            Box(
                modifier = Modifier
                    .fillMaxSize() // Remplit tout l'espace disponible.
                    .padding(innerPadding), // Respecte les marges internes définies par Scaffold.
                contentAlignment = Alignment.TopCenter // Aligne le contenu en haut et au centre.
            )
            {

                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Commandes", style = MaterialTheme.typography.titleLarge)
                    // Affiche le titre de la section des commandes.
                    Spacer(modifier = Modifier.height(16.dp)) // Ajoute un espace vertical.

                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(), // La liste occupe toute la largeur disponible.
                        verticalArrangement = Arrangement.spacedBy(16.dp) // Ajoute un espace entre les éléments.
                    )
                    {
                        items(orders) { order ->
                            OrderItem(order) // Affiche chaque commande en utilisant le composable `OrderItem`.
                            ProgressIndicator()
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp)) // Ajoute un espace après la liste.
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.padding(5.dp), // Ajoute une marge autour de la barre inférieure.
                containerColor = appBarColor, // Applique la couleur personnalisée à la barre inférieure.
                contentColor = Color.Black // Définit la couleur du contenu de la barre inférieure.
            ) {
                Text("Accueil", modifier = Modifier.padding(8.dp)) // Affiche l'élément "Accueil".
                Spacer(modifier = Modifier.weight(1f)) // Ajoute un espace flexible.
                Text("Commandes", modifier = Modifier.padding(8.dp)) // Affiche l'élément "Commandes".
                Spacer(modifier = Modifier.weight(1f)) // Ajoute un autre espace flexible.
                Text("Profil", modifier = Modifier.padding(8.dp)) // Affiche l'élément "Profil".
            }
        }
    )
}

@Preview(showBackground = true) // Permet de prévisualiser le composable dans l'éditeur.
@Composable
fun MainScreenPreview() {
    DwitchAppTheme { // Applique le thème de l'application.
        MainScreen() // Affiche le composable `MainScreen` dans l'aperçu.
    }
}



