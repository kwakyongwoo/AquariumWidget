package com.dyddyd.aquariumwidget.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.dyddyd.aquariumwidget.core.designsystem.component.ImageMaxSize
import com.dyddyd.aquariumwidget.feature.splash.R


@Composable
internal fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    HomeScreen(
        modifier = modifier,
    )
}


@Composable
fun HomeScreen(
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

            Spacer(modifier = Modifier.height(32.dp))

            HomeBottom(modifier = Modifier)
        }
    }
}

@Composable
private fun HomeBottom(
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

            HomeBottomBar()
        }
    }
}

@Composable
private fun HomeBottomBar() {
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
            items(5) {
                Image(
                    painter = painterResource(id = R.drawable.home_bottom_bar_item),
                    contentDescription = "Home Bottom Bar Item",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxHeight()
                )
            }
        }
    }
}