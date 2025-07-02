package com.wazker.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.wazker.R
import com.wazker.presentation.design_system.theme.Theme

@Composable
fun WazkerButton(
    icon: Int,
    size: Dp,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(Theme.colors.surfaceColors.wazkerButton)
            .size(size)
            .clickable { onClick() }
    ){
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
private fun Preview(){
    Column {
        WazkerButton(icon = R.drawable.ic_plus , size = 60.dp , onClick = {})
        WazkerButton(icon = R.drawable.ic_menu, size = 40.dp , onClick = {} , modifier = Modifier.padding(vertical = 16.dp))
        WazkerButton(icon = R.drawable.ic_back , size = 40.dp , onClick = {})
    }
}