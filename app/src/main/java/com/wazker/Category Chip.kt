package com.wazker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.wazker.ui.theme.categoryChip1
import com.wazker.ui.theme.categoryChip2

@Composable
fun CategoryChip(
    text: String
    //onClick: () -> Unit

){
    Box (
        modifier = Modifier
            .size(width = 326.dp, height = 169.dp)
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(size = 10.dp))
            .background(brush = Brush.verticalGradient(
                colors = listOf(
                    categoryChip1,
                    categoryChip2
                )
            )
            )
        //.clickable { onClick() }
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
        CategoryChip("أذكار الصباح")
        CategoryChip("أذكار المساء")

    }

}


