package com.example.dwitchapp.models

import java.time.LocalDateTime

// models

data class Order(
    val id: String? = null,
    val date: LocalDateTime, // Changement en LocalDateTime
    val documentID: String? = null,
    val placedAt: String? = null,
    val receivedAt: String? = null,
    val cookMessage: String? = null,
    val price: Long? = null,
    val progress: Long? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val publishedAt: String? = null,
    val ingredients: List<Ingredient>? = null,
    val usersPermissionsUser: UsersPermissionsUser? = null,
    val store: Store? = null
)

data class Ingredient(
    val id: String? = null,
    val documentID: String? = null,
    val name: String? = null,
    val description: String? = null,
    val isVegan: Boolean? = null,
    val isSpicy: Boolean? = null,
    val kind: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val publishedAt: String? = null
)

data class Store(
    val id: Long? = null,
    val documentID: String? = null,
    val name: String? = null,
    val isOpen: Boolean? = null,
    val city: String? = null,
    val zipCode: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val publishedAt: String? = null
)

data class UsersPermissionsUser(
    val id: Long? = null,
    val documentID: String? = null,
    val username: String? = null,
    val email: String? = null,
    val provider: String? = null,
    val confirmed: Boolean? = null,
    val blocked: Boolean? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val publishedAt: String? = null
)

// mocks (objets simulés pour instancier les classes)

val mockOrder = Order(
    id = "1",
    documentID = "ORD123456",
    placedAt = "2024-06-01T10:00:00Z",
    receivedAt = "2024-06-01T11:00:00Z",
    cookMessage = "Extra spicy",
    price = 20L,
    progress = 50L,
    createdAt = "2024-06-01T09:50:00Z",
    updatedAt = "2024-06-01T10:05:00Z",
    publishedAt = "2024-06-01T10:10:00Z",
    date = LocalDateTime.now(), // Utilisation de LocalDateTime
    ingredients = listOf(
        Ingredient(
            id = "1",
            documentID = "ING123",
            name = "Tomato",
            description = "Fresh tomatoes",
            isVegan = true,
            isSpicy = false,
            kind = "Vegetable",
            createdAt = "2024-05-31T10:00:00Z",
            updatedAt = "2024-05-31T11:00:00Z",
            publishedAt = "2024-05-31T12:00:00Z"
        )
    ),
    usersPermissionsUser = UsersPermissionsUser(
        id = 1L,
        documentID = "USR123",
        username = "john_doe",
        email = "john.doe@example.com",
        provider = "local",
        confirmed = true,
        blocked = false,
        createdAt = "2024-05-01T10:00:00Z",
        updatedAt = "2024-05-10T11:00:00Z",
        publishedAt = "2024-05-11T12:00:00Z"
    ),
    store = Store(
        id = 1L,
        documentID = "STR123",
        name = "Downtown Store",
        isOpen = true,
        city = "Chambéry",
        zipCode = "73000",
        createdAt = "2024-04-01T10:00:00Z",
        updatedAt = "2024-05-01T11:00:00Z",
        publishedAt = "2024-05-01T12:00:00Z"
    )
)

val mockOrders = listOf(
    Order(
        id = "1",
        date = LocalDateTime.now(),
        ingredients = listOf(
            Ingredient(name = "Tomato", kind = "Vegetable"),
            Ingredient(name = "Chicken", kind = "Meat"),
            Ingredient(name = "Chili", kind = "Spicy"),
            Ingredient(name = "Yogurt", kind = "Dairy")
        )
    ),
    Order(
        id = "2",
        date = LocalDateTime.now().minusDays(1),
        ingredients = listOf(
            Ingredient(name = "Bread", kind = "Bread"),
            Ingredient(name = "Cheese", kind = "Dairy"),
            Ingredient(name = "Chili", kind = "Spicy"),
            Ingredient(name = "Yogurt", kind = "Dairy")

        )
    )
)

