package com.blc.darkchat.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blc.darkchat.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "1 new message",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.sen)),
                )
            )
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
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.outline_mode_edit_outline_24),
                    contentDescription = null,
                    tint = Color(0xFFCCCCCC)
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = null,
                    tint = Color(0xFFCCCCCC)
                )
            }
        },
    )
}