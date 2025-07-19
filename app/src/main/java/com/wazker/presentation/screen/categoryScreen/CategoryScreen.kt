package com.wazker.presentation.screen.categoryScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wazker.R
import com.wazker.presentation.components.CategoryChip
import com.wazker.presentation.components.WazkerTextField
import com.wazker.presentation.design_system.theme.Theme


@Composable
fun CategoryScreen(){
    CategoryScreenContent()
}

@Composable
fun CategoryScreenContent(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Theme.colors.secondary)
    ){
        WazkerTextField(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            value = "",
            onValueChange = {},
            icon = R.drawable.ic_back,
            hint = "Search",
            singleLine = true,
            enabled = true,
        )
        LazyColumn(
            modifier = Modifier
                .padding(top = 38.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp),
        ) {
            items(10){
                CategoryChip(
                    text = "",
                    isCategoryTitle = false,
                    onClick = {},
                    modifier = Modifier,
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview(){
    CategoryScreen()
}