package com.dyddyd.aquariumwidget.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import com.dyddyd.aquariumwidget.core.designsystem.component.AquariumTopAppBar
import com.dyddyd.aquariumwidget.navigation.AquariumNavHost
import com.dyddyd.aquariumwidget.navigation.TopLevelDestination

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
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
            ) {
                val destination = appState.currentTopLevelDestination

                if (destination != TopLevelDestination.SPLASH) {
                    Column(
                        modifier = Modifier
                            .zIndex(1f)
                    ) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(90 / 16f) // Home Top Background aspect ratio
                        )

                        AquariumTopAppBar(
                            modifier = Modifier
                        )
                    }
                }

                AquariumNavHost(appState = appState)
            }
        }
    }
}