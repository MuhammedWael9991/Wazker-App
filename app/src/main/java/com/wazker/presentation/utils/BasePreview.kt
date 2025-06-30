package com.wazker.presentation.utils

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.wazker.presentation.design_system.theme.Theme
import com.wazker.presentation.design_system.theme.WazkerTheme

@Composable
fun BasePreview( modifier: Modifier = Modifier , content: @Composable () -> Unit) {
    WazkerTheme {
        Surface(modifier = modifier,color = Theme.colors.surfaceColors.details) {
            content()
        }
    }
}