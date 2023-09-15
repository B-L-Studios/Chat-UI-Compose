package com.blc.darkchat.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.blc.darkchat.R
import com.blc.darkchat.ui.extensions.coloredShadow
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun CallScreen(navController: NavController) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = Color(0xFF1C1B1B),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.janet),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .coloredShadow(
                    color = Color(0xFF007EF4).copy(alpha = 0.5f),
                    borderRadius = 200.dp,
                    blurRadius = 850.dp,
                    offsetY = 0.dp,
                    offsetX = 0.dp,
                    spread = 30f
                )
                .size(200.dp)
                .clip(RoundedCornerShape(100))
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Janet Fowler",
            style = TextStyle(
                color = Color.White,
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.sen))
            )
        )

        Text(
            text = "Calling...",
            style = TextStyle(
                color = Color(0xFFCCCCCC),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.sen))
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .padding(bottom = 16.dp)
                .size(64.dp)
                .clip(CircleShape),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Color(0xFFFF6969),
                contentColor = Color.White
            )
        ) {
            Icon(
                imageVector = Icons.Outlined.Phone,
                contentDescription = null
            )
        }
    }
}