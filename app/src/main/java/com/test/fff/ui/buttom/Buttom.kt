package com.test.fff.ui.buttom

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.test.fff.R

fun JetsnackBottomBar(tabs: Array<HomeSections>){

}

enum class HomeSections(
    @StringRes val title: Int,
    val icon: ImageVector,
    val route: String
) {
    FEED(R.string.tab1, Icons.Outlined.Menu, "home/feed"),
    SEARCH(R.string.tab2, Icons.Outlined.Search, "home/search")
}