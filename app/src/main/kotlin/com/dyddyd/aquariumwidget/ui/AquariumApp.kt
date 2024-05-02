package com.dyddyd.aquariumwidget.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
        Row(modifier = Modifier.fillMaxSize()) {
            Box(
                Modifier.fillMaxSize()
            ) {
                val destination = appState.currentTopLevelDestination
                if (destination != TopLevelDestination.SPLASH) {
                    Column(
                        modifier = Modifier
                            .zIndex(1f)
                    ) {
                        if (destination == TopLevelDestination.HOME) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(90 / 16f)
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        AquariumTopAppBar(
                            modifier = if (destination != TopLevelDestination.HOME)
                                Modifier.padding(padding)
                            else Modifier,
                        )
                    }
                }

                AquariumNavHost(appState = appState)
            }
        }
    }
}