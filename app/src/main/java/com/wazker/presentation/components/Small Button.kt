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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wazker.R
import com.wazker.presentation.design_system.theme.Theme
import com.wazker.presentation.utils.BasePreview
import com.wazker.presentation.utils.PreviewMultiDevices



@Composable
fun SmallChip(
    text: String,
    onClick: () -> Unit

){
    Box (
        modifier = Modifier
            .height(132.dp)
            .width(132.dp)
            .clip(shape = RoundedCornerShape(size = 12.dp))
            .background(color= Theme.colors.primary)
            .clickable { onClick() }
    ){
        Image(
            painter = painterResource(id = R.drawable.quran3),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .alpha(0.1f)
                .align(Alignment.BottomEnd)
                .offset(y = 30.dp,x = 20.dp)

        )
        Text(
            text = text,
            color = Theme.colors.text.title,
            style = Theme.textStyleSora.headline.medium,
            modifier = Modifier
                .align(Alignment.Center)

        )

    }

}




@Preview(showSystemUi = true , device = Devices.PIXEL_6)
@Composable
private fun SmallChipPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
        ,verticalArrangement = Arrangement.Center
        ,horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SmallChip("أذكار الصباح",onClick = {})
        Spacer(modifier = Modifier.height(32.dp))
        SmallChip("أذكار المساء",onClick = {})

    }

}
@Preview()
@Composable
private fun SmallChipPreview2() {
    SmallChip("أذكار الصباح",onClick = {})

}

@PreviewMultiDevices
@Composable
private fun SmallChipPreview3() {
    BasePreview {
        Column(
            modifier = Modifier

            ,verticalArrangement = Arrangement.Center
            ,horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SmallChip("أذكار الصباح",onClick = {})

        }
    }
}
