package com.example.littlelemonapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
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
        Column {
            UpperPanel()
            LowerPanel(navController, DishInfo.dishes)

        }
    }
}

