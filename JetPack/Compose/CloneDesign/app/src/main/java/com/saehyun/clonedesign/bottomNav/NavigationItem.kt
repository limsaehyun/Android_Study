package com.saehyun.clonedesign.bottomNav

sealed class NavigationItem(val route: String) {
    object WarningList : NavigationItem("warningList")

    object Main : NavigationItem("main")
}