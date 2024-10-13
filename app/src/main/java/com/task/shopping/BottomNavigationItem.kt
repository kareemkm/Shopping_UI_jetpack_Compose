package com.task.shopping

sealed class BottomNavigationItem(
    val rout: String,
    val icon: Int
) {
    object Home:BottomNavigationItem(
        rout = "home",
        icon = R.drawable.home
    )
    object Notification:BottomNavigationItem(
        rout = "notification",
        icon = R.drawable.notification
    )
    object Scan:BottomNavigationItem(
        rout = "scan",
        icon = R.drawable.scan
    )
    object Time:BottomNavigationItem(
        rout = "time",
        icon = R.drawable.time
    )
    object Shopping:BottomNavigationItem(
        rout = "shopping",
        icon = R.drawable.shoping
    )
}