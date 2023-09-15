package com.blc.darkchat.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.blc.darkchat.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatAppBar(navController: NavController) {
    CenterAlignedTopAppBar(
        title = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Janet Fowler",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.sen)),
                    )
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Online",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.sen)),
                    )
                )
            }
        },
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    bottomStart = 30.dp,
                    bottomEnd = 30.dp
                )
            ),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFF1F1F1F)
        ),
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = { navController.navigate("call") }) {
                Icon(
                    imageVector = Icons.Outlined.Call,
                    contentDescription = null,
                    tint = Color(0xFF007EF4)
                )
            }
        },
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    )
}