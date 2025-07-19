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
import com.wazker.R
import com.wazker.presentation.design_system.theme.Theme
import com.wazker.presentation.utils.BasePreview
import com.wazker.presentation.utils.PreviewMultiDevices

private val CATEGORY_TITLE_HEIGHT = 123.dp
private val CATEGORY_ITEM_HEIGHT = 169.dp

@Composable
fun CategoryChip(
    text: String,
    isCategoryTitle: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Box (
        modifier = modifier
            .height(if (isCategoryTitle) CATEGORY_TITLE_HEIGHT else CATEGORY_ITEM_HEIGHT)
            .padding(horizontal = 16.dp)
            .clip(shape = RoundedCornerShape(size = 10.dp))
            .background(brush = Brush.verticalGradient(
                colors = Theme.colors.surfaceColors.categoryChip.colors
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
            color = Theme.colors.text.title,
            style = Theme.textStyleSora.headline.large,
            modifier = Modifier
                .align(Alignment.Center)

        )

    }

}




@Preview(showSystemUi = true , device = Devices.PIXEL_6)
@Composable
private fun CategoryChipPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
        ,verticalArrangement = Arrangement.Center
        ,horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CategoryChip("أذكار الصباح",onClick = {},isCategoryTitle = false)
        Spacer(modifier = Modifier.height(32.dp))
        CategoryChip("أذكار المساء",onClick = {},isCategoryTitle = false)

    }

}


@PreviewMultiDevices
@Composable
private fun CategoryChipPreview3() {
    BasePreview {
        Column(
            modifier = Modifier

            ,verticalArrangement = Arrangement.Center
            ,horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CategoryChip("أذكار الصباح",onClick = {},isCategoryTitle = false)
            Spacer(modifier = Modifier.height(32.dp))
            CategoryChip("أذكار المساء",onClick = {},isCategoryTitle = true)

        }
    }
}
