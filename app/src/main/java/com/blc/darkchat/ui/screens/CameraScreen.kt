package com.blc.darkchat.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import com.blc.darkchat.ui.components.CameraBox
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraScreen(navController: NavController) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = Color.Transparent,
    )

    val cameraPermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> {
                    cameraPermissionState.launchPermissionRequest()
                }

                else -> {}
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    CameraBox(
        navController = navController,
        context = context,
        lifecycleOwner = lifecycleOwner,
    )
}