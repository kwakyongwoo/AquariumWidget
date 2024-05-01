package com.dyddyd.aquariumwidget.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImagePainter.State.Empty.painter

@Composable
fun ImageMaxSize(
    painter: Painter,
    contentDescription: String? = null,
) {
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}