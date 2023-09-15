package com.blc.darkchat.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun DarkChatComposeTheme(
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    val systemUiController = rememberSystemUiController()
    val window = (view.context as Activity).window

    WindowCompat.setDecorFitsSystemWindows(window, false)

    systemUiController.setSystemBarsColor(
        color = Color(0xFF1F1F1F),
    )

    MaterialTheme(
        typography = Typography,
        content = content
    )
}