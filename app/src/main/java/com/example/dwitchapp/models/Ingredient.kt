package com.example.dwitchapp.models

import androidx.compose.ui.graphics.Color

enum class IngredientType(val emoji: String, val color: Color) {
    VEGETABLE("🥬", Color(0xFF4CAF50)),
    BREAD("🍞", Color(0xFFFFC107)),
    MEAT("🍖", Color(0xFF795548)),
    DAIRY("🧀", Color(0xFFFFEB3B))
}


fun String.toIngredientType(): IngredientType? = when (this.lowercase()) {
    "vegetable" -> IngredientType.VEGETABLE
    "bread" -> IngredientType.BREAD
    "meat" -> IngredientType.MEAT
    "dairy" -> IngredientType.DAIRY
    else -> null
}
