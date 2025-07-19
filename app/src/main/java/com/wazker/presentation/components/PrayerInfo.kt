package com.wazker.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PrayerInfo(
    name: List<String>,
    time: List<String>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        name.forEach {
            PrayerBox(
                name = it,
                time = time[name.indexOf(it)]
            )
        }
    }
}


@Preview
@Composable
private fun Preview(){
    PrayerInfo(
        name = listOf("Fajr", "Dhuhr", "Asr", "Maghrib", "Isha"),
        time = listOf("05:00 AM", "12:30 PM", "03:45 PM", "06:15 PM", "07:30 PM")
    )
}