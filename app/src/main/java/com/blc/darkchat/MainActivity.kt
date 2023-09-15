package com.blc.darkchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.blc.darkchat.ui.screens.CallScreen
import com.blc.darkchat.ui.screens.CameraScreen
import com.blc.darkchat.ui.screens.ChatScreen
import com.blc.darkchat.ui.screens.HomeScreen
import com.blc.darkchat.ui.theme.DarkChatComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DarkChatComposeTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color(0xFF1C1B1B)
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            HomeScreen(navController = navController)
                        }
                        composable("chat") {
                            ChatScreen(navController = navController)
                        }
                        composable("camera") {
                            CameraScreen(navController = navController)
                        }
                        composable("call") {
                            CallScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}