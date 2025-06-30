package com.wazker.presentation.design_system.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.wazker.presentation.design_system.color.LocalWazkerColors
import com.wazker.presentation.design_system.color.WazkerColors
import com.wazker.presentation.design_system.text_style.LocalDualFontTextStyle
import com.wazker.presentation.design_system.text_style.LocalWazkerTextStyle
import com.wazker.presentation.design_system.text_style.WazkerTextStyle

object Theme {
    val colors: WazkerColors
        @Composable
        @ReadOnlyComposable
        get() = LocalWazkerColors.current

    val textStyleAmiri: WazkerTextStyle
        @Composable
        @ReadOnlyComposable
        get() = LocalDualFontTextStyle.current.arabic

    val textStyleSora: WazkerTextStyle
        @Composable
        @ReadOnlyComposable
        get() = LocalDualFontTextStyle.current.english
}