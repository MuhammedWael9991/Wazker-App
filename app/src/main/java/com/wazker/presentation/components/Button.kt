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
fun Button(
    title: String,
    isEnabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(
                Brush.linearGradient(
                    if (isEnabled)
                        Theme.colors.surfaceColors.categoryChip.colors
                    else
                        Theme.colors.surfaceColors.categoryChip.colors.map { it.copy(alpha = 0.2f) }
                )
            )
            .clickable{
                if (isEnabled)
                    onClick()
            }
    ){
        Text(
            text = title,
            color = if (isEnabled) Theme.colors.text.title else Theme.colors.text.title.copy(alpha = 0.2f),
            style = Theme.textStyleSora.body.medium,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun ButtonPreview(){
    Column(
        modifier = Modifier
    ) {
        Button(title = "حفظ", isEnabled = true, onClick = {})
        Button(modifier = Modifier.padding(vertical = 16.dp), title = "الغاء", isEnabled = true, onClick = {})
        Button(title = "حفظ", isEnabled = false, onClick = {})
    }
}
