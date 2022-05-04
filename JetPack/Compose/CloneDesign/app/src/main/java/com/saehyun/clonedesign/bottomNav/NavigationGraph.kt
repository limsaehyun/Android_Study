package com.saehyun.clonedesign.bottomNav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.saehyun.clonedesign.ui.application.ApplicationScreen
import com.saehyun.clonedesign.ui.feed.FeedScreen
import com.saehyun.clonedesign.ui.mypage.MyPageScreen
import com.saehyun.clonedesign.ui.notification.NotificationScreen

@Composable
fun NavigationGraph(navBarController: NavHostController, navController: NavHostController) {
    NavHost(navBarController, startDestination = BottomNavItem.Feed.screen_route) {
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
            MyPageScreen(navController)
        }
    }
}