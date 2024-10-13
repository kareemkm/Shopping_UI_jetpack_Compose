package com.task.shopping

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.task.shopping.view.HomeScreen
import com.task.shopping.view.MainScreen
import com.task.shopping.view.Payment
import com.task.shopping.view.Shopping
import com.task.shopping.view.SplashScreen
import com.task.shopping.view.SuccessfulPayment
import kotlinx.coroutines.delay

@Composable
fun App(){

    var viewSplash by remember { mutableStateOf(true) }
    val navController = rememberNavController()

    LaunchedEffect(key1 = true) {
        delay(6000)
        viewSplash = false
    }

    NavHost(
        navController = navController,
        startDestination = if (viewSplash) "splash" else "main"
    ){
        composable("splash") { SplashScreen(onClick = {viewSplash = false}) }
        composable("main") { MainScreen(navController = navController) }
        composable("home") { HomeScreen(navController = navController) }
        composable("shopping") { Shopping(navController = navController) }
        composable("payment") { Payment(navController = navController) }
        composable("successfulPayment") { SuccessfulPayment(navController = navController) }
    }
}