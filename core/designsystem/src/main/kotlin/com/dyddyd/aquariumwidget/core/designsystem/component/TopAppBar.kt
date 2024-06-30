package com.dyddyd.aquariumwidget.core.designsystem.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.dyddyd.aquariumwidget.core.designsystem.R

@Composable
fun AquariumTopAppBar(
    modifier: Modifier = Modifier,
) {
    var isSideBarOpen by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        AnimatedVisibility(
            modifier = modifier
                .zIndex(1f),
            visible = isSideBarOpen,
            enter = slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(300)
            ),
            exit = slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(300)
            )
        ) {
            Row() {
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)
                        .clickable(
                            // remove indication
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }) {
                            isSideBarOpen = false
                        }
                ) {}

                AquariumSideBar(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.8f)
                        .fillMaxWidth(0.8f)
                )
            }
        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(64.dp)
                .padding(vertical = 8.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.core_designsystem_topappbar_icon),
                contentDescription = "Top App Bar Icon",
                modifier = Modifier
                    .fillMaxHeight()
            )

            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(4.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.core_designsystem_topappbar_quest),
                    contentDescription = "Top App Bar Menu",
                    modifier = Modifier
                        .fillMaxHeight(),
                    contentScale = ContentScale.FillHeight
                )

                Image(
                    painter = painterResource(id = R.drawable.core_designsystem_topappbar_menu),
                    contentDescription = "Top App Bar Menu",
                    modifier = Modifier
                        .fillMaxHeight()
                        .clickable {
                            isSideBarOpen = !isSideBarOpen
                        },
                    contentScale = ContentScale.FillHeight
                )
            }
        }
    }
}

@Composable
private fun AquariumSideBar(
    modifier: Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.core_designsystem_sidebar_background),
            contentDescription = "Side Bar Background",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Preview("Top App Bar")
@Composable
private fun AquariumTopAppBarPreview() {
    Box(
        modifier = Modifier.background(Color.White)
    ) {
        AquariumTopAppBar()
    }
}