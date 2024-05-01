package com.dyddyd.aquariumwidget.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFFEBCD))
    ) {


        HomeBottom(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun HomeContent(
) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,

            ) {

            Image(
                painter = painterResource(id = R.drawable.home_game_button),
                contentDescription = "Home Game Button",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 36.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxHeight(0.03f)
            )

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
                    .fillMaxHeight(0.13f)
            ) {

            }

            HomeBottom(
                modifier = Modifier
            )
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
            modifier = Modifier.fillMaxWidth()
        )

        HomeBottomBar(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
private fun HomeBottomBar(
    modifier: Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {

        Image(
            painter = painterResource(id = R.drawable.home_bottom_bar),
            contentDescription = "Home Bottom Bar",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
        )

        LazyRow(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(24.dp),
        ) {
//            items(5) {
//                Image(
//                    painter = painterResource(id = R.drawable.home_bottom_bar_item),
//                    contentDescription = "Home Bottom Bar Item",
//                    contentScale = ContentScale.FillHeight,
//                    modifier = Modifier
//                        .fillMaxHeight()
//                        .padding(8.dp)
//                )
//            }
        }

//        LazyRow(
//            modifier = Modifier
//                .align(Alignment.Center)
//                .fillMaxWidth()
////                .aspectRatio(3f)
//                .padding(24.dp),
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//        ) {
//            items(5) {
//                Image(
//                    painter = painterResource(id = R.drawable.home_bottom_bar_item),
//                    contentDescription = "Home Bottom Bar Item",
//                    contentScale = ContentScale.FillBounds,
//                    modifier = Modifier
//                        .fillMaxHeight()
//                        .aspectRatio(1f)
//                )
//            }
//        }
    }
}