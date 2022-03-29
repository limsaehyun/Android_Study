package com.saehyun.clonedesign.ui.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.saehyun.clonedesign.bottomNav.BottomNavigationBar
import com.saehyun.clonedesign.bottomNav.NavigationGraph

@Composable
fun MainScreen(navController: NavHostController) {

    val navBarController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navBarController) }
    ) {
        NavigationGraph(navBarController, navController)
    }
}