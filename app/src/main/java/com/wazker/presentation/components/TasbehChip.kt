package com.wazker.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wazker.presentation.design_system.theme.Theme

@Composable
fun TasbehChip(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(67.dp)
            .padding(horizontal = 6.dp)
            .clip(RoundedCornerShape(11.dp))
            .background(
                brush = Brush.linearGradient(
                    Theme.colors.surfaceColors.categoryChip.colors
                )
            )
            .clickable{ onClick() }
    ){
        Text(
            text = title,
            color = Theme.colors.text.title,
            style = Theme.textStyleAmiri.headline.medium,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
private fun Preview(){
    Column {
        TasbehChip(title = "سبحان الله" , onClick = {})
        TasbehChip(title = "الحمدلله" , onClick = {} , modifier = Modifier.padding(vertical = 16.dp))
        TasbehChip(title = "الله اكبر" , onClick = {})
    }
}

