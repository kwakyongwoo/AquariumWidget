package com.dyddyd.aquariumwidget.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dyddyd.aquariumwidget.core.designsystem.R

val neoDunggenunmo = FontFamily(
    Font(R.font.neo_dunggeunmo_pro_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.neo_dunggeunmo_pro_regular, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.neo_dunggeunmo_pro_regular, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.neo_dunggeunmo_pro_regular, FontWeight.Light, FontStyle.Normal),
    Font(R.font.neo_dunggeunmo_pro_regular, FontWeight.Thin, FontStyle.Normal),
)
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = neoDunggenunmo,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)