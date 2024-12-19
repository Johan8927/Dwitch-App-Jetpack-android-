package com.example.dwitchapp.Compenents

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dwitchapp.models.mockOrders
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue

@Composable
fun ProgressIndicator() {
    var loading by remember { mutableStateOf(false) } // Gère l'état de chargement
    val scope = rememberCoroutineScope() // Crée un scope de coroutine pour gérer les tâches asynchrones

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = {
            loading = true
            scope.launch {
                loadProgress() // Lance la progression
                loading = false // Réinitialise l'état de chargement une fois la coroutine terminée
            }
        }, enabled = !loading) {
            Text("Start loading") // Bouton qui lance le chargement
        }

        // Affiche la barre de progression pour chaque commande dans mockOrders
        if (loading) {
            mockOrders.forEach { order ->
                order.progress?.let { progress ->
                    LinearProgressIndicator(
                        progress = progress / 100f, // Calcul de la progression sur 100%
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }
        }
    }
}

suspend fun loadProgress() {
    // Simule un délai pour le chargement, ajustez selon le besoin
    delay(1000)
}
