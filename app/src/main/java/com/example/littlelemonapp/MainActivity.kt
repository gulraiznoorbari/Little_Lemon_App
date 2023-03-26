package com.example.littlelemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
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
//                    LoginScreen()
            }
        }
    }
}

@Composable
fun AppScreen() {
    // sets and remembers the basic state for a scaffold e.g. Drawer configuration:
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = { DrawerPanel(scaffoldState = scaffoldState, scope = scope) },
        topBar = {
            TopAppBar(scaffoldState = scaffoldState, scope = scope)
        }
    ) {
        MyNavigation()
    }
}

@Composable
fun MyNavigation() {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = Home.route) {
        composable(Home.route) { HomeScreen(navController = navigationController) }
        composable(
            DishDetails.route + "/{${DishDetails.argDishId}}",
            arguments = listOf(
                navArgument(DishDetails.argDishId) { type = NavType.IntType }
            )) {
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


