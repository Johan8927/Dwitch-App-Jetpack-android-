import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dwitchapp.models.Ingredient
import com.example.dwitchapp.models.IngredientType
import com.example.dwitchapp.models.Order
import com.example.dwitchapp.models.toIngredientType
import java.time.format.DateTimeFormatter

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
        Text(formattedDate, color = Color.Gray, fontSize = 14.sp)

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