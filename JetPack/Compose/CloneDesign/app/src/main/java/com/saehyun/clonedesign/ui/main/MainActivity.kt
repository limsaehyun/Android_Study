package com.saehyun.clonedesign.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saehyun.clonedesign.bottomNav.NavigationItem
import com.saehyun.clonedesign.theme.CloneDesignTheme
import com.saehyun.clonedesign.ui.mypage.WarningListUI

class MainActivity : ComponentActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CloneDesignTheme {
                DSMApplication()
            }
        }
    }
}

@Composable
fun DSMApplication(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationItem.Main.route
    ) {
        composable(NavigationItem.Main.route) { MainScreen(navController) }

        composable(NavigationItem.WarningList.route) { WarningListUI(navController) }
    }
}