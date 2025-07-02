package com.wazker.presentation.design_system.color

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class WazkerColors(
    val primary: Color,
    val secondary: Color,
    val primaryGradient: PrimaryGradient,
    val text: WazkerTextColor,
    val surfaceColors: SurfaceColors
)

data class PrimaryGradient(
    val colors: List<Color>,
)

data class WazkerTextColor(
    val title: Color,
    val body: Color,
    val hint: Color
)

data class SurfaceColors(
    val details: Color,
    val wazkerButton: Color,
    val categoryChip: CategoryChip,
    val searchBar: SearchBar,
    val saveButton: SaveButton
)

data class CategoryChip(
    val colors: List<Color>,
)

data class SearchBar(
    val colors: List<Color>,
)

data class SaveButton(
    val colors: List<Color>,
)

val LocalWazkerColors = staticCompositionLocalOf { lightThemeColors }