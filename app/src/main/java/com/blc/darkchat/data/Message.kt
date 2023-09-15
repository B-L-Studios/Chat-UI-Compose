package com.blc.darkchat.data

data class Message(
    val message: String,
    val time: String,
    val isMe: Boolean
)

val listOfMessages = listOf(
    Message("Hi there!", "9:00 AM", true),
    Message("Hello!", "9:02 AM", false),
    Message("How are you?", "9:05 AM", true),
    Message("I'm doing well, thanks!", "9:07 AM", false),
    Message("What have you been up to? You've been gone lately", "9:10 AM", true),
    Message("Just working on some stuff.", "9:12 AM", false),
    Message("That sounds busy!", "9:15 AM", true),
    Message("And tiring!", "9:15 AM", true),
    Message("Yeah, it's been hectic lately.", "9:18 AM", false)
).reversed()