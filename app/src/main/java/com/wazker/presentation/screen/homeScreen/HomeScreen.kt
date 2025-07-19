package com.wazker.presentation.screen.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wazker.R
import com.wazker.presentation.components.CategoryChip
import com.wazker.presentation.design_system.theme.Theme


@Composable
fun HomeScreen(){
    HomeScreenContent()
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier
){
    val state = true
    Scaffold(
        bottomBar = {
            // BottomBar()
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(
                        brush = Brush.verticalGradient(
                            Theme.colors.primaryGradient.colors
                        )
                    )
            ) {
                if (state) {
                    HomeContent()
                } else {
                    ShowError()
                }
            }
        }
    )
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxSize()

    ){
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "09:30 AM",
                style = Theme.textStyleSora.headline.large,
                color = Theme.colors.text.title,
                modifier = Modifier
                    .padding(top = 16.dp)
            )
            Text(
                text = "Next Prayer:\nFajr\nAfter:\n 30 minutes",
                style = Theme.textStyleSora.headline.medium,
                color = Theme.colors.text.title,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 16.dp)
            )
            HorizontalDivider(
                color = Theme.colors.text.title,
                thickness = 1.dp,
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .padding(horizontal = 16.dp)
            )

            CategoryChip(
                text = "أذكار الصباح",
                isCategoryTitle = false,
                onClick = { /* Handle click */ },
            )
            CategoryChip(

                text = stringResource(R.string.favourites),
                isCategoryTitle = false,
                onClick = { /* Handle click */ },
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }

    }
}
@Composable
fun ShowError(){

}
@Composable
fun ShowLoading(){

}

@Preview
@Composable
private fun Preview(){
    HomeScreen()
}