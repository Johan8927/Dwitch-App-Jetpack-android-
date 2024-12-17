package com.example.dwitchapp.models

import androidx.compose.ui.graphics.Color

enum class IngredientType(val emoji: String, val color: Color) {
    VEGETABLE("🥬", Color(0xFF4CAF50)),
    SPICY("🌶️", Color(0xFFE53935)),
    MEAT("🍖", Color(0xFF795548)),
    DAIRY("🧀", Color(0xFFFFEB3B)),
    OTHER("🍴", Color(0xFF9E9E9E));
}

// Extension pour récupérer le type selon une chaîne
fun String.toIngredientType(): IngredientType = when (this.lowercase()) {
    "vegetable" -> IngredientType.VEGETABLE
    "spicy" -> IngredientType.SPICY
    "meat" -> IngredientType.MEAT
    "dairy" -> IngredientType.DAIRY
    else -> IngredientType.OTHER
}
