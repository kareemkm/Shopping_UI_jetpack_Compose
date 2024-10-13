package com.task.shopping.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.task.shopping.BottomNavigationItem

@Composable
fun MainScreen(navController: NavController){
    val bottomNavController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Column(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController = bottomNavController,
                startDestination = "home",
                modifier = Modifier.fillMaxSize().background(Color.White)
            ) {
                composable(BottomNavigationItem.Home.rout) { HomeScreen(navController = navController) }
                composable(BottomNavigationItem.Notification.rout) { Notification() }
                composable(BottomNavigationItem.Scan.rout) { Scan() }
                composable(BottomNavigationItem.Time.rout) { Time() }
                composable(BottomNavigationItem.Shopping.rout) { Shopping(navController = navController) }
            }
        }
        BottomBarNavigation(navController = bottomNavController, modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun BottomBarNavigation(navController: NavController,modifier: Modifier){

    val currentRout = navController.currentBackStackEntryAsState().value?.destination?.route

    val screens = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Notification,
        BottomNavigationItem.Scan,
        BottomNavigationItem.Time,
        BottomNavigationItem.Shopping
    )

    BottomNavigation(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .shadow(elevation = 18.dp, shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp) )
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .clickable(indication = null, interactionSource = remember { MutableInteractionSource() }){},
        backgroundColor = Color.White
    ) {
        screens.forEach { screen ->
            BottomNavigationItem(

                icon = {
                    Icon(
                        painter = painterResource(screen.icon),
                        contentDescription = null,
                        tint = if (currentRout == screen.rout) Color(0xFF2DC0FF) else Color(0xFFBBBBBB),
                        modifier = Modifier
                            .clip(RoundedCornerShape(15.dp))
                            .background(if(currentRout == screen.rout) Color(0xFF2DC0FF).copy(alpha = 0.2f) else Color.Transparent)
                            .padding(10.dp)
                    )
                },
                selected = currentRout == screen.rout,
                onClick = {
                    if(currentRout != screen.rout){
                        navController.navigate(screen.rout){
                            popUpTo(navController.graph.startDestinationId){saveState = true}
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                modifier = Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }

                ){}
            )
        }
    }
}
