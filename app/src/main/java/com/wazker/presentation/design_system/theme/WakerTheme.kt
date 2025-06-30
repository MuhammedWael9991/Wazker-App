package com.wazker.presentation.design_system.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.wazker.presentation.design_system.color.LocalWazkerColors
import com.wazker.presentation.design_system.color.darkThemeColors
import com.wazker.presentation.design_system.color.lightThemeColors
import com.wazker.presentation.design_system.text_style.DualFontTextStyle
import com.wazker.presentation.design_system.text_style.LocalDualFontTextStyle
import com.wazker.presentation.design_system.text_style.amiriTextStyle
import com.wazker.presentation.design_system.text_style.soraTextStyle

@Composable
fun WazkerTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
){
    val colors = if (!isDarkTheme) darkThemeColors else lightThemeColors

    CompositionLocalProvider(
        LocalWazkerColors provides colors,
        LocalDualFontTextStyle provides DualFontTextStyle(
            arabic = amiriTextStyle,
            english = soraTextStyle
        )
    ){
        content()
    }

}