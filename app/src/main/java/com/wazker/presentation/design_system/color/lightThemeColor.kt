package com.wazker.presentation.design_system.color

import androidx.compose.ui.graphics.Color

val lightThemeColors = WazkerColors(
    primary = Color(0xFF49BAF2),
    secondary = Color(0xFF092052),
    primaryGradient = PrimaryGradient(
        listOf(
            Color(0xFF49BAF2),
            Color(0xFF092052)
        )
    ),
    text = WazkerTextColor(
        title = Color(0xFFFFFFFF),
        body = Color(0xFF65D6FC),
        hint = Color(0x4AFBFBFB)
    ),
    surfaceColors = SurfaceColors(
        details = Color(0xFF0A2060),
        categoryChip = CategoryChip(
            listOf(
                Color(0xFF65D6FC),
                Color(0xFF455EB5)
            )
        ),
        searchBar = SearchBar(
            listOf(
                Color(0xFF65D6FC),
                Color(0xFF006385)
            )
        ),
        saveButton = SaveButton(
            listOf(
                Color(0x8065D6FC),
                Color(0xFF455EB5)
            )
        )
    )
)
