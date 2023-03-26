package com.example.littlelemonapp

interface Destinations {
    val route: String
}

object Login : Destinations {
    override val route = "Login"
}

object Home : Destinations {
    override val route = "Home"
}

object DishDetails : Destinations {
    override val route = "Menu"
    const val argDishId = "dishId"
}
