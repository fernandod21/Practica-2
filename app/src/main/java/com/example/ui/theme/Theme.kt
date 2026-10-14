package com.example.ui.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Esquema de colores para Modo Claro con paleta Rojo, Negro y Blanco
val BacanoLightColorScheme = lightColorScheme(
    primary = BacanoRed,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFEBEE),
    onPrimaryContainer = Color(0xFFB71C1C),
    secondary = BacanoBlack,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFE4E4E7),
    onSecondaryContainer = Color(0xFF18181B),
    tertiary = Color(0xFFC62828),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFFFCDD2),
    onTertiaryContainer = Color(0xFF7F0000),
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = Color(0xFF52525B),
    outline = LightOutline,
    outlineVariant = LightOutlineVariant
)

// Esquema de colores para Modo Oscuro con paleta Rojo, Negro y Blanco
val BacanoDarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = Color.White,
    primaryContainer = Color(0xFF5C1D1D),
    onPrimaryContainer = Color(0xFFFFCDD2),
    secondary = DarkSecondary,
    onSecondary = Color(0xFF121212),
    secondaryContainer = Color(0xFF27272A),
    onSecondaryContainer = Color(0xFFF4F4F5),
    tertiary = DarkAccent,
    onTertiary = Color(0xFF121212),
    tertiaryContainer = Color(0xFF491212),
    onTertiaryContainer = Color(0xFFFF8A80),
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = Color(0xFFA1A1AA),
    outline = DarkOutline,
    outlineVariant = DarkOutlineVariant
)

/**
 * Anima suavemente todas las transiciones de color del ColorScheme
 * cuando el usuario alterna entre tema claro y oscuro (Requisito 5: Animaciones).
 */
@Composable
fun animatedColorScheme(targetScheme: ColorScheme): ColorScheme {
    val duration = 350
    val animSpec = tween<Color>(durationMillis = duration)

    val primary = animateColorAsState(targetScheme.primary, animSpec, label = "primary").value
    val onPrimary = animateColorAsState(targetScheme.onPrimary, animSpec, label = "onPrimary").value
    val primaryContainer = animateColorAsState(targetScheme.primaryContainer, animSpec, label = "primaryContainer").value
    val onPrimaryContainer = animateColorAsState(targetScheme.onPrimaryContainer, animSpec, label = "onPrimaryContainer").value
    val secondary = animateColorAsState(targetScheme.secondary, animSpec, label = "secondary").value
    val onSecondary = animateColorAsState(targetScheme.onSecondary, animSpec, label = "onSecondary").value
    val secondaryContainer = animateColorAsState(targetScheme.secondaryContainer, animSpec, label = "secondaryContainer").value
    val onSecondaryContainer = animateColorAsState(targetScheme.onSecondaryContainer, animSpec, label = "onSecondaryContainer").value
    val tertiary = animateColorAsState(targetScheme.tertiary, animSpec, label = "tertiary").value
    val onTertiary = animateColorAsState(targetScheme.onTertiary, animSpec, label = "onTertiary").value
    val background = animateColorAsState(targetScheme.background, animSpec, label = "background").value
    val onBackground = animateColorAsState(targetScheme.onBackground, animSpec, label = "onBackground").value
    val surface = animateColorAsState(targetScheme.surface, animSpec, label = "surface").value
    val onSurface = animateColorAsState(targetScheme.onSurface, animSpec, label = "onSurface").value
    val surfaceVariant = animateColorAsState(targetScheme.surfaceVariant, animSpec, label = "surfaceVariant").value
    val onSurfaceVariant = animateColorAsState(targetScheme.onSurfaceVariant, animSpec, label = "onSurfaceVariant").value
    val outline = animateColorAsState(targetScheme.outline, animSpec, label = "outline").value
    val outlineVariant = animateColorAsState(targetScheme.outlineVariant, animSpec, label = "outlineVariant").value

    return targetScheme.copy(
        primary = primary,
        onPrimary = onPrimary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        secondary = secondary,
        onSecondary = onSecondary,
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = onSecondaryContainer,
        tertiary = tertiary,
        onTertiary = onTertiary,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        surfaceVariant = surfaceVariant,
        onSurfaceVariant = onSurfaceVariant,
        outline = outline,
        outlineVariant = outlineVariant
    )
}

/**
 * Tema principal de Bacano con paleta Rojo, Negro y Blanco.
 * Soporta alternancia de tema claro/oscuro con animación suave y tipografía unificada.
 */
@Composable
fun BacanoTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit
) {
    val targetScheme = if (darkTheme) BacanoDarkColorScheme else BacanoLightColorScheme
    val animatedScheme = animatedColorScheme(targetScheme)

    MaterialTheme(
        colorScheme = animatedScheme,
        typography = BacanoTypography,
        content = content
    )
}
