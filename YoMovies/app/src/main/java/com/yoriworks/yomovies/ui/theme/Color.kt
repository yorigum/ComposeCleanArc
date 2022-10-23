package com.yoriworks.yomovies.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val BlueGrey900 = Color(0xFF263238)

val Colors.statusBarColor
    get() = if (isLight) Purple700 else BlueGrey900

val Colors.titleColor
    get() = if (isLight) Color.Black else Color.White

val Colors.topAppbarBackgroundColor
    get() = if (isLight) Purple700 else  BlueGrey900