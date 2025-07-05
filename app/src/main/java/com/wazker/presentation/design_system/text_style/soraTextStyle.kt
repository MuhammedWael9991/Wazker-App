package com.wazker.presentation.design_system.text_style


import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val soraTextStyle = WazkerTextStyle(
    headline = SizedTextStyle(
        large = TextStyle(
            fontFamily = sora, fontWeight = FontWeight.Bold, fontSize = 40.sp
        ),
        medium = TextStyle(
            fontFamily = sora, fontWeight = FontWeight.Bold, fontSize = 20.sp
        ),
        small = TextStyle(
            fontFamily = sora, fontWeight = FontWeight.Bold, fontSize = 14.sp
        )
    ),
    title = SizedTextStyle(
        large = TextStyle(
            fontFamily = sora, fontWeight = FontWeight.Bold, fontSize = 32.sp
        ),
        medium = TextStyle(
            fontFamily = sora, fontWeight = FontWeight.Normal, fontSize = 16.sp
        ),
        small = TextStyle(
            fontFamily = sora, fontWeight = FontWeight.Medium, fontSize = 16.sp
        )
    ),
    body = SizedTextStyle(
        large = TextStyle(
            fontFamily = sora, fontWeight = FontWeight.SemiBold, fontSize = 96.sp
        ),
        medium = TextStyle(
            fontFamily = sora, fontWeight = FontWeight.Normal, fontSize = 16.sp
        ),
        small = TextStyle(
            fontFamily = sora, fontWeight = FontWeight.Normal, fontSize = 14.sp
        )
    ),
    label = SizedTextStyle(
        large = TextStyle(
            fontFamily = sora, fontWeight = FontWeight.Bold, fontSize = 16.sp
        ),
        medium = TextStyle(
            fontFamily = sora, fontWeight = FontWeight.Medium, fontSize = 14.sp
        ),
        small = TextStyle(
            fontFamily = sora, fontWeight = FontWeight.Medium, fontSize = 12.sp
        )
    ),
)