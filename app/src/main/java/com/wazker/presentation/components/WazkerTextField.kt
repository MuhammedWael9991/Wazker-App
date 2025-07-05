package com.wazker.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wazker.R
import com.wazker.presentation.design_system.theme.Theme

@Composable
fun WazkerTextField(
    value: String,
    onValueChange: (String) -> Unit,
    icon: Int,
    hint: String,
    modifier: Modifier = Modifier,
    singleLine: Boolean = true,
    enabled: Boolean = true
){

    var isFocused by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }

    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is FocusInteraction.Focus -> isFocused = true
                is FocusInteraction.Unfocus -> isFocused = false
            }
        }
    }

    val borderColor = when {
        isFocused -> listOf(
            Theme.colors.primaryGradient.colors[1],
            Theme.colors.primaryGradient.colors[0]
        )
        else -> listOf(
            Theme.colors.text.hint,
            Theme.colors.text.hint
        )
    }
    val backgroundColor = when {
        isFocused -> Color.White.copy(alpha = 0.05f)
        else -> Color.White.copy(alpha = 0f)
    }

    val textColor = if (isFocused) {
        Theme.colors.text.body
    } else {
        Theme.colors.text.hint
    }

    BasicTextField(
        value = value,
        enabled = enabled,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(60.dp)
            .border(
                width = 1.dp,
                brush = Brush.linearGradient(
                    colors = borderColor
                ),
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor),
        singleLine = singleLine,
        textStyle = Theme.textStyleSora.body.medium.copy(color = textColor),
        cursorBrush = SolidColor(Theme.colors.primary),
        interactionSource = interactionSource,
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier.fillMaxHeight().padding(start = 22.dp)
            ){
                Image(
                    painter = painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.CenterVertically)
                )
                VerticalDivider(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .padding(start = 16.dp),
                    thickness = 1.dp
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    if (value.isEmpty()) {
                        Text(
                            text = hint,
                            style = Theme.textStyleSora.body.medium,
                            color = Theme.colors.text.hint,
                            modifier = Modifier
                        )
                    }
                    innerTextField()
                }

            }
        }
    )
}



@Preview
@Composable
private fun Preview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    Theme.colors.primaryGradient.colors
                )
            ),
        verticalArrangement = Arrangement.Center
    ) {
        WazkerTextField(
            value = "",
            icon = R.drawable.ic_menu,
            hint = "اكتب هنا",
            modifier = Modifier,
            onValueChange = {},
            enabled = true,
            singleLine = true
        )
    }
}