package com.saehyun.clonedesign.bottomNav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.saehyun.clonedesign.ApplicationScreen
import com.saehyun.clonedesign.FeedScreen
import com.saehyun.clonedesign.MyPageScreen
import com.saehyun.clonedesign.ui.notification.NotificationScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Feed.screen_route) {
        composable(BottomNavItem.Feed.screen_route) {
            FeedScreen()
        }
        composable(BottomNavItem.Application.screen_route) {
            ApplicationScreen()
        }
        composable(BottomNavItem.Notification.screen_route) {
            NotificationScreen()
        }
        composable(BottomNavItem.MyPage.screen_route) {
            MyPageScreen()
        }
    }
}