package com.wazker.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.wazker.presentation.design_system.theme.Theme
import kotlinx.coroutines.launch

@Composable
fun WazkerBottomSheet(
    visible: Boolean,
    onDismiss: () -> Unit,
    onSaveClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {

        var text by remember { mutableStateOf("enabled") }
        val offsetY = remember { Animatable(0f) }
        val scope = rememberCoroutineScope()


        if (visible) {
           Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .clickable { onDismiss() }
            )
        }
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically(
                initialOffsetY = { fullHeight -> fullHeight },
            ) + fadeIn(),
            exit = slideOutVertically(
                targetOffsetY = { fullHeight -> fullHeight }
            ) + fadeOut(),
            modifier = Modifier.align(Alignment.BottomCenter)
        )
        {
            Column(
                modifier = Modifier
                    .offset{IntOffset(0, offsetY.value.toInt())}
                    .draggable(
                        orientation = Orientation.Vertical,
                        state = rememberDraggableState { delta ->
                            scope.launch {
                                offsetY.snapTo((offsetY.value + delta).coerceAtLeast(0f))
                            }

                        },
                        onDragStopped = {
                            if (offsetY.value > 200f) {
                                scope.launch {
                                    offsetY.animateTo(1000f)
                                    onDismiss()
                                    offsetY.snapTo(0f)
                                }
                            } else {
                                scope.launch {
                                    offsetY.animateTo(0f)
                                }
                            }
                        }
                    )
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                    .background(brush = Brush.verticalGradient(
                        colors = Theme.colors.surfaceColors.bottomSheet.colors
                    ))
                    .padding(vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Box(
                    modifier = Modifier
                        .padding(bottom = 24.dp)
                        .size(width = 40.dp, height = 4.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(Color.Gray.copy(alpha = 0.5f))
                        .align(Alignment.CenterHorizontally)
                )

                Button(
                    title = "حفظ",
                    isEnabled = text.isNotBlank(),
                    onClick = {
                        onSaveClicked(text)
                    }
                )


                Button(
                    title = "إلغاء",
                    isEnabled = true,
                    onClick = { onDismiss() },
                    modifier = Modifier.padding(top = 16.dp)
                )

            }



        }

    }


}

@Preview(showSystemUi = true)
@Composable
fun BottomSheetPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        WazkerBottomSheet(onDismiss = {}, onSaveClicked = {}, visible = true)
    }


}