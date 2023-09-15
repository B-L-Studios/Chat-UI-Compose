package com.blc.darkchat.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blc.darkchat.R
import com.blc.darkchat.data.Conversation

@Composable
fun ConversationItem(conversation: Conversation, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(vertical = 22.dp)
            .fillMaxWidth()
            .height(60.dp)
            .clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = conversation.image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .height(60.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = conversation.sender,
                    maxLines = 1,
                    modifier = Modifier.weight(1f),
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.sen)),
                    )
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = conversation.time,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.sen)),
                    )
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = buildAnnotatedString {
                        append(if (conversation.amILastSender) "You: " else "")
                        append(conversation.message)
                    },
                    modifier = Modifier.weight(1f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.sen)),
                    )
                )

                Spacer(modifier = Modifier.width(10.dp))

                if (conversation.unread)
                    ReadIndicator()
            }
        }
    }
}

@Composable
fun ReadIndicator() {
    Box(
        modifier = Modifier
            .size(12.dp)
            .clip(CircleShape)
            .background(Color(0xFF007EF4))
    )
}