package com.example.littlelemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.littlelemonapp.ui.theme.LittleLemonAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonAppTheme {
                AppScreen()
            }
        }
    }
}

@Composable
fun AppScreen() {
        MyNavigation()
}

@Composable
fun MyNavigation() {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = Login.route) {
        composable(Login.route) { LoginScreen(navigationController = navigationController) }
        composable(Home.route) { HomeScreen(navController = navigationController) }
        composable(
            DishDetails.route + "/{${DishDetails.argDishId}}",
            arguments = listOf(
                navArgument(DishDetails.argDishId) { type = NavType.IntType }
            )
        ) {
            val id = requireNotNull(it.arguments?.getInt(DishDetails.argDishId)) { "Dish id is null" }
            DishDetails(id)
        }
    }
}


// For Preview in Android Studio:
@Preview(showBackground = true)
@Composable
fun AppScreenPreview(){
    AppScreen()
}


