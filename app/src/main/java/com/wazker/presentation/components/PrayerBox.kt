package com.wazker.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.wazker.presentation.design_system.theme.Theme


@Composable
fun PrayerBox(
    name: String,
    time: String,
    modifier: Modifier = Modifier,
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    ){
        Text(
            text = time,
            style = TextStyle(
                fontFamily = Theme.textStyleSora.headline.medium.fontFamily,
                fontSize = Theme.textStyleAmiri.headline.medium.fontSize,
                fontWeight = Theme.textStyleAmiri.headline.medium.fontWeight,
                color = Theme.colors.text.title
            ),
            modifier = Modifier.align(Alignment.CenterStart)
        )
        Text(
            text = name,
            style = TextStyle(
                fontFamily = Theme.textStyleAmiri.headline.medium.fontFamily,
                fontSize = Theme.textStyleAmiri.headline.medium.fontSize,
                fontWeight = Theme.textStyleAmiri.headline.medium.fontWeight,
                color = Theme.colors.text.title
            ),
            modifier = Modifier.align(Alignment.CenterEnd)
        )
        HorizontalDivider(
            modifier = Modifier
                .padding(top = 21.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            color = Theme.colors.text.hint,
            thickness = 1.dp
        )
    }
}

@Preview
@Composable
private fun Preview(){
    PrayerBox(
        name = "الفجر",
        time = "05:00 AM",
    )
}
