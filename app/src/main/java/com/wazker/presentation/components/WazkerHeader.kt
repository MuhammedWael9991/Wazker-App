package com.wazker.presentation.components


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wazker.presentation.design_system.theme.Theme
import com.wazker.R

@Composable
fun WazkerHeader(
    id: Long,
    modifier: Modifier = Modifier
) {

    var isSaved by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Theme.colors.surfaceColors.details),

        ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_copy),
                contentDescription = "Copy",
                tint = Theme.colors.primary,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        Toast
                            .makeText(context, "Cobied to clipboard", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
            Icon(
                painter = painterResource(
                    if (isSaved) R.drawable.ic_save_selected else R.drawable.ic_save_not_selected
                ),
                contentDescription = "bookmark",
                tint = Theme.colors.primary,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { isSaved = !isSaved }
            )

        }
        WazkerShape(
            number = id.toInt(),
            isRound = true,
            modifier = Modifier
                .align(alignment = Alignment.CenterEnd)
                .padding(end = 16.dp)
        )
    }


}

@Preview(showSystemUi = true, device = Devices.PIXEL_6)
@Composable
private fun WazkerHeaderPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WazkerHeader(2)
    }

}

