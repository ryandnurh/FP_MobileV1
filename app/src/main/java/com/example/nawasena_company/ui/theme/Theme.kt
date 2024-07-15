package com.example.nawasena_company.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    onPrimary = MainColor2,
    onSecondary = FontColor2,
    onTertiary = CardColor2,
    onPrimaryContainer = FontTitle2,
    onSecondaryContainer = CardSoft2,
    onTertiaryContainer = ProfileTitle2,
    primaryContainer = Round2,
    secondaryContainer = Button2,
    tertiaryContainer = TextField2,
    inversePrimary = TextFade2,
    background = Background2,
    onBackground = BarButton2,
    inverseSurface = ProfileData2,
    inverseOnSurface = Text2,
    onSurface = Search2,
    onSurfaceVariant = Value2,
    onErrorContainer = PriceColor2,
//    outline = DateColor2

)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    onPrimary = MainColor1,
    onSecondary = FontColor1,
    onTertiary = CardColor1,
    onPrimaryContainer = FontTitle1,
    onSecondaryContainer = CardSoft1,
    onTertiaryContainer = ProfileTitle1,
    primaryContainer = Round1,
    secondaryContainer = Button1,
    tertiaryContainer = TextField1,
    inversePrimary = TextFade1,
    background = Background1,
    onBackground = BarButton1,
    inverseSurface = ProfileData1,
    inverseOnSurface = Text1,
    onSurface = Search1,
    onSurfaceVariant = Value1,
    onErrorContainer = PriceColor1,
    outline = DateColor1


)

@Composable
fun Nawasena_CompanyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}