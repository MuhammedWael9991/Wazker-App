package com.wazker.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wazker.R


@Composable
fun CategoryChip(
    text: String,
    onClick: () -> Unit

){
    Box (
        modifier = Modifier
            .height(169.dp)
            .padding(horizontal = 24.dp)
            .clip(shape = RoundedCornerShape(size = 10.dp))
            .background(brush = Brush.verticalGradient(
                colors = listOf(
                    categoryChip1,
                    categoryChip2
                )
            )
            )
        .clickable { onClick() }
    ){
        Image(
            painter = painterResource(id = R.drawable.mosque),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
            ,alignment = Alignment.BottomCenter

        )
        Text(
            text = text,
            color = Color.White,
            fontSize = 40.sp,
            modifier = Modifier
                .align(Alignment.Center)

        )

    }

}

@Preview(showSystemUi = true , device = Devices.PIXEL_6)
@Composable
fun CategoryChipPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
        ,verticalArrangement = Arrangement.Center
        ,horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CategoryChip("أذكار الصباح",onClick = {})
        Spacer(modifier = Modifier.height(32.dp))
        CategoryChip("أذكار المساء",onClick = {})

    }

}

val categoryChip1 = Color(0xFF65D6FC)
val categoryChip2 = Color(0xFF455EB5)
