package com.dydyd.aquariumwidget.feature.fishing

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dyddyd.aquariumwidget.core.designsystem.component.noRippleClickable

@Composable
internal fun FishingRoute(
    viewModel: FishingViewModel = hiltViewModel(),
) {
    val fishingUiState by viewModel.fishingUiState.collectAsStateWithLifecycle()

    FishingScreen(
        fishingUiState = fishingUiState,
        decreaseChance = viewModel::decreaseChance,
        resetChance = viewModel::resetChance,
    )
}

@Composable
fun FishingScreen(
    fishingUiState: FishingUiState,
    decreaseChance: () -> Unit,
    resetChance: () -> Unit,
) {
    val context = LocalContext.current
    var catching by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        when (fishingUiState) {
            FishingUiState.Loading,
            FishingUiState.Error,
            -> Unit

            is FishingUiState.Success -> {
                val resourceId = context.resources.getIdentifier(
                    "feature_fishing_${fishingUiState.habitat.imageUrl?.lowercase()}",
                    "drawable",
                    context.packageName
                )

                Image(
                    painter = painterResource(id = resourceId),
                    contentDescription = "Habitat Background",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .align(Alignment.TopStart)
                ) {
                    Box(modifier = Modifier.fillMaxHeight(30 / 195f))

                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        repeat(fishingUiState.chance) {
                            item {
                                Image(
                                    painter = painterResource(id = R.drawable.feature_fishing_heart_fill),
                                    contentDescription = "Heart Fill",
                                    modifier = Modifier.width(24.dp),
                                    contentScale = ContentScale.FillWidth
                                )

                                Box(modifier = Modifier.width(8.dp))
                            }
                        }

                        repeat(5 - fishingUiState.chance) {
                            item {
                                Image(
                                    painter = painterResource(id = R.drawable.feature_fishing_heart_empty),
                                    contentDescription = "Heart Empty",
                                    modifier = Modifier.width(24.dp),
                                    contentScale = ContentScale.FillWidth
                                )

                                Box(modifier = Modifier.width(8.dp))
                            }
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth(82 / 90f)
                        .fillMaxHeight(142 / 195f)
                        .align(Alignment.TopEnd)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.feature_fishing_cat),
                        contentDescription = "Fishing Cat",
                        modifier = Modifier
                            .fillMaxWidth(16 / 90f)
                            .align(Alignment.BottomStart),
                        contentScale = ContentScale.FillWidth
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth(71 / 90f)
                        .fillMaxHeight(152 / 195f)
                        .align(Alignment.TopEnd)
                        .clickable {
                            resetChance()
                        }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.feature_fishing_rod),
                        contentDescription = "Fishing Rod",
                        modifier = Modifier
                            .fillMaxWidth(1 / 3f)
                            .align(Alignment.BottomStart),
                        contentScale = ContentScale.FillWidth
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth(37 / 90f)
                        .fillMaxHeight(152 / 195f)
                        .align(Alignment.TopEnd)
                ) {
                    Image(
                        painter = painterResource(
                            id =
                            if (fishingUiState.chance != 0) R.drawable.feature_fishing_button_enable
                            else R.drawable.feature_fishing_button_disable
                        ),
                        contentDescription = "Fishing Button",
                        modifier = Modifier
                            .fillMaxWidth(34 / 37f)
                            .align(Alignment.BottomStart)
                            .noRippleClickable {
                                decreaseChance()
                            },
                        contentScale = ContentScale.FillWidth
                    )
                }
            }
        }
    }
}
