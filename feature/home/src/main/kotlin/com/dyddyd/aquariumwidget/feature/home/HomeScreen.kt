package com.dyddyd.aquariumwidget.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dyddyd.aquariumwidget.core.designsystem.component.ImageMaxSize
import com.dyddyd.aquariumwidget.core.designsystem.theme.AquariumWidgetTheme
import com.dyddyd.aquariumwidget.core.ui.FishUiState
import com.dyddyd.aquariumwidget.core.ui.fishList
import com.dyddyd.aquariumwidget.feature.splash.R


@Composable
internal fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val fishUiState by viewModel.fishUiState.collectAsStateWithLifecycle()

    HomeScreen(
        fishUiState = fishUiState,
        modifier = modifier,
    )
}


@Composable
fun HomeScreen(
    fishUiState: FishUiState,
    modifier: Modifier,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.home_top_background),
            contentDescription = "Home Top Background",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
        )

        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color(0xFFFFEBCD)),
            verticalArrangement = Arrangement.Bottom
        ) {
            Image(
                painter = painterResource(id = R.drawable.home_game_button),
                contentDescription = "Home Game Button",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp)
            )

            Spacer(modifier = Modifier.fillMaxHeight(0.1f))

            HomeBottom(
                fishUiState = fishUiState,
                modifier = Modifier,
            )
        }
    }
}

@Composable
private fun HomeBottom(
    fishUiState: FishUiState,
    modifier: Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.home_bottom_background),
            contentDescription = "Home Bottom Background",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.Bottom
        ) {

            Image(
                painter = painterResource(id = R.drawable.home_aquarium),
                contentDescription = "Home Aquarium",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(5f)
            )

            HomeBottomBar(
                fishUiState = fishUiState
            )
        }
    }
}

@Composable
private fun HomeBottomBar(
    fishUiState: FishUiState,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(3f)
    ) {

        ImageMaxSize(
            painter = painterResource(id = R.drawable.home_bottom_bar),
            contentDescription = "Home Bottom Bar",
        )

        LazyRow(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(24.dp)
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
           fishList(fishUiState = fishUiState)
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    AquariumWidgetTheme {
        HomeScreen(
            fishUiState = FishUiState.Loading,
            modifier = Modifier,
        )
    }
}