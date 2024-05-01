package com.dyddyd.aquariumwidget.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dyddyd.aquariumwidget.navigation.AquariumNavHost

@Composable
fun AquariumApp(
    appState: AquariumAppState = rememberAquariumAppState(

    ),
) {

    Scaffold(
        modifier = Modifier,
    ) { padding ->
        padding
        Row(
            Modifier
                .fillMaxSize()
//                .padding(padding)
//                .consumeWindowInsets(padding)
//                .windowInsetsPadding(
//                    WindowInsets.safeDrawing.only(
//                        WindowInsetsSides.Horizontal,
//                    ),
//                ),
        ) {

            Column(
                Modifier.fillMaxSize()
            ) {
                AquariumNavHost(appState = appState)
            }
        }
    }
}