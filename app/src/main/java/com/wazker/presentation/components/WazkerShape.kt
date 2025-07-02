package com.wazker.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wazker.presentation.design_system.theme.Theme

@Composable
fun WazkerShape(
    number: Int,
    isRound: Boolean,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .size(26.dp)
            .clip(shape = if (isRound) CircleShape else RoundedCornerShape(size = 5.dp))
            .background(Theme.colors.primary)
    ){
        Text(
            text = number.toString(),
            color = Theme.colors.text.title,
            style = Theme.textStyleSora.title.small,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
private fun Preview(){
    Column {
        WazkerShape(1 , true)
        WazkerShape(2 , false , modifier = Modifier.padding(vertical = 16.dp))
        WazkerShape(3 , false)
    }
}