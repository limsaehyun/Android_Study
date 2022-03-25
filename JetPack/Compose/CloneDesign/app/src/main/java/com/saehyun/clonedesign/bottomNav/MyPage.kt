package com.saehyun.clonedesign.bottomNav

sealed class MyPage(val route: String) {
    object WarningList: MyPage("myPage/warningList")
}