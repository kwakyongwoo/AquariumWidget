package com.dyddyd.aquariumwidget.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dyddyd.aquariumwidget.core.model.data.Fish

fun LazyListScope.fishList(
    fishUiState: FishUiState,
) {
    when (fishUiState) {
        is FishUiState.Success -> {
            items(fishUiState.fishList.size) { index ->
                val fish = fishUiState.fishList[index]
                FishItem(fish = fish)
            }
        }

        else -> Unit
    }
}

sealed interface FishUiState {

    data object Loading : FishUiState
    data object LoadFailed : FishUiState
    data class Success(
        val fishList: List<Fish>,
    ) : FishUiState
}

@Composable
fun FishItem(
    fish: Fish,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.core_ui_fish_background_default),
            contentDescription = "Fish Background",
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize()
        )

        FishImage(
            imageUrl = fish.imageUrl ?:"fish_default_image",
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp),
        )
    }
}

@Composable
fun FishImage(
    imageUrl: String,
    modifier: Modifier
) {
    val context = LocalContext.current
    val resourceId = context.resources.getIdentifier("core_ui_fish_${imageUrl.lowercase()}", "drawable", context.packageName)

    if (resourceId != 0) {
        val painter = painterResource(id = resourceId)

        Image(
            painter = painter,
            contentDescription = "Fish Image",
            contentScale = if (painter.intrinsicSize.width > painter.intrinsicSize.height) {
                ContentScale.FillWidth
            } else {
                ContentScale.FillHeight
            },
            modifier = modifier
        )
    }
}

@Preview(name = "Fish Item")
@Composable
private fun FishItemPreview() {
    FishItem(
        fish = Fish(
            fishId = 1,
            name = "Minnow",
            rarity = "Common",
            description = "Minnows are small, freshwater fish that inhabit ponds, often characterized by their slender bodies and silvery scales.",
            imageUrl = "Minnow",
            habitatId = 1
        ),
        modifier = Modifier
            .size(100.dp)
    )
}