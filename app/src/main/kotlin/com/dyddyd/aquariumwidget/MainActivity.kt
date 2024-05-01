package com.dyddyd.aquariumwidget

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.dyddyd.aquariumwidget.core.designsystem.theme.AquariumWidgetTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import com.dyddyd.aquariumwidget.MainActivityUiState.Loading
import com.dyddyd.aquariumwidget.ui.AquariumApp
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
//        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        var uiState: MainActivityUiState by mutableStateOf(Loading)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState
                    .onEach { uiState = it }
                    .collect()
            }
        }

        // Splash api 에서 background가 image로 설정이 안되기 때문에 splash screen을 사용하지 않음
//        splashScreen.setKeepOnScreenCondition {
//            when (uiState) {
//                Loading -> true
//                is Success -> false
//            }
//        }

        enableEdgeToEdge()
        setContent {
            val activity = (LocalContext.current as Activity)
            val windowInsetsController = remember {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    activity.window.insetsController
                } else {
                    null
                }
            }

            DisposableEffect(Unit) {
                enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.light(
                        android.graphics.Color.TRANSPARENT,
                        android.graphics.Color.TRANSPARENT,
                    ),
                    navigationBarStyle = SystemBarStyle.light(
                        android.graphics.Color.TRANSPARENT,
                        android.graphics.Color.TRANSPARENT,
                    ),
                )

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    windowInsetsController?.let {
                        it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                        it.hide(WindowInsets.Type.navigationBars())
                    }

                    onDispose {
                        windowInsetsController?.show(WindowInsets.Type.navigationBars())
                    }
                } else {
                    val decorView = activity.window.decorView
                    val originalSystemUiVisibility = decorView.systemUiVisibility
                    decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                            View.SYSTEM_UI_FLAG_FULLSCREEN or
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

                    onDispose {
                        decorView.systemUiVisibility = originalSystemUiVisibility
                    }
                }
            }

            AquariumWidgetTheme {
                AquariumApp()
            }
        }
    }
}
