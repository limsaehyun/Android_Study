package com.saehyun.clonedesign.bottomNav

import com.saehyun.clonedesign.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {

    object Feed : BottomNavItem("급식", R.drawable.ic_feed, "feed")
    object Application : BottomNavItem("신청", R.drawable.ic_application, "application")
    object Notification : BottomNavItem("공지", R.drawable.ic_notification, "notification")
    object MyPage : BottomNavItem("마이페이지", R.drawable.ic_mypage, "my_page")
}