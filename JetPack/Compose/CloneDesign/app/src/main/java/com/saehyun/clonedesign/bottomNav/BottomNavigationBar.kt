package com.saehyun.clonedesign.bottomNav

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.saehyun.clonedesign.theme.HalfMint
import com.saehyun.clonedesign.theme.Mint
import java.nio.file.Files.size

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Feed,
        BottomNavItem.Application,
        BottomNavItem.Notification,
        BottomNavItem.MyPage
    )
    BottomNavigation(
        backgroundColor = Mint,
        contentColor = HalfMint
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.size(20.dp).padding(bottom = 6.dp)
                    )},
                label = { Text(text = item.title) },
                selectedContentColor = Color.Companion.White,
                unselectedContentColor = HalfMint,
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}