package com.saehyun.clonedesign.ui.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.saehyun.clonedesign.bottomNav.BottomNavigationBar
import com.saehyun.clonedesign.bottomNav.NavigationGraph

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        NavigationGraph(navController)
    }
}
