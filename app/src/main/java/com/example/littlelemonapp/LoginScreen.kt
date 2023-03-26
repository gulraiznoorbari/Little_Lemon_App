package com.example.littlelemonapp

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun LoginScreen(navigationController: NavHostController) {
    var context = LocalContext.current
    var username by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Little Lemon Logo:
        Image(
            painter = painterResource(id = R.drawable.littlelemonlogo),
            contentDescription = "Little Lemon Logo",
            modifier = Modifier.padding(10.dp)
        )

        // Username Field:
        TextField(
            value = username,
            onValueChange = { newUsername -> username = newUsername },
            label = { Text(text = "Username") },
            modifier = Modifier.padding(10.dp)
        )

        // Password Field:
        TextField(
            value = password,
            onValueChange = { newPassword -> password = newPassword },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.padding(10.dp)
        )

        // Submit Button:
        Button(
            onClick = {
                if (username.text == "John" && password.text == "helloworld") {
                    Toast.makeText(context, "Welcome to Little Lemon!", Toast.LENGTH_SHORT).show()
                    navigationController.navigate(Home.route)
                }
                else {
                    Toast.makeText(context, "Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show()
                }
            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF495E57)),
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Login", color = Color(0xFFEDEFEE))
        }
    }
}


