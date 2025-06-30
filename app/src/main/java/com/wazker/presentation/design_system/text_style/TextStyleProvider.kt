package com.wazker.presentation.design_system.text_style

import androidx.compose.runtime.staticCompositionLocalOf

data class DualFontTextStyle(
    val arabic: WazkerTextStyle,
    val english: WazkerTextStyle
)

val LocalDualFontTextStyle = staticCompositionLocalOf {
    DualFontTextStyle(
        arabic = amiriTextStyle,
        english = soraTextStyle
    )
}
