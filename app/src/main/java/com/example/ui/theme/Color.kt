package com.example.ui.theme

import androidx.compose.ui.graphics.Color

/**
 * ========================================================================
 * PALETA DE 3 COLORES DEL SISTEMA DE DISEÑO - BACANO (ROJO, NEGRO Y BLANCO)
 * ========================================================================
 * Paleta oficial solicitada: Negro, Blanco y Rojo.
 * Se aplican de forma consistente en toda la aplicación para garantizar
 * contraste, accesibilidad y una estética moderna y profesional.
 */

// 1. Color Rojo: Rojo Bacano (#E53935) - Primario, acción, energía y calidez
val BacanoRed = Color(0xFFE53935)
const val BacanoRedHex = "#E53935"

// 2. Color Negro: Negro Carbón (#121212) - Secundario, estructura y soporte visual
val BacanoBlack = Color(0xFF121212)
const val BacanoBlackHex = "#121212"

// 3. Color Blanco: Blanco Puro (#FFFFFF) - Base, luminosidad y contraste
val BacanoWhite = Color(0xFFFFFFFF)
const val BacanoWhiteHex = "#FFFFFF"

// Alias semánticos para el tema
val BacanoPrimary = BacanoRed
const val BacanoPrimaryHex = BacanoRedHex

val BacanoSecondary = BacanoBlack
const val BacanoSecondaryHex = BacanoBlackHex

val BacanoAccent = BacanoWhite
const val BacanoAccentHex = BacanoWhiteHex

/**
 * Modelo de datos para presentar la paleta en la interfaz de usuario.
 */
data class ColorSwatch(
    val name: String,
    val role: String,
    val hex: String,
    val color: Color,
    val onColor: Color,
    val usageDescription: String
)

val BacanoThreeColorPalette = listOf(
    ColorSwatch(
        name = "Rojo Bacano",
        role = "Primario",
        hex = BacanoRedHex,
        color = BacanoRed,
        onColor = Color.White,
        usageDescription = "Botones de acción principal, estados dinámicos y acentos visuales"
    ),
    ColorSwatch(
        name = "Negro Carbón",
        role = "Secundario",
        hex = BacanoBlackHex,
        color = BacanoBlack,
        onColor = Color.White,
        usageDescription = "Estructura, tipografía de alto contraste y soporte de componentes"
    ),
    ColorSwatch(
        name = "Blanco Puro",
        role = "Base / Contraste",
        hex = BacanoWhiteHex,
        color = BacanoWhite,
        onColor = Color(0xFF121212),
        usageDescription = "Superficies limpias, espacios de lectura y contraste óptimo"
    )
)

// ------------------------------------------------------------------------
// Tokens de Superficie y Fondo para Tema Claro (Light Theme)
// ------------------------------------------------------------------------
val LightBackground = Color(0xFFFAFAFA)
val LightSurface = Color(0xFFFFFFFF)
val LightSurfaceVariant = Color(0xFFF4F4F5)
val LightOnBackground = Color(0xFF121212)
val LightOnSurface = Color(0xFF121212)
val LightOutline = Color(0xFFD4D4D8)
val LightOutlineVariant = Color(0xFFE4E4E7)

// ------------------------------------------------------------------------
// Tokens de Superficie y Fondo para Tema Oscuro (Dark Theme)
// ------------------------------------------------------------------------
val DarkBackground = Color(0xFF0F0F10)
val DarkSurface = Color(0xFF18181B)
val DarkSurfaceVariant = Color(0xFF27272A)
val DarkOnBackground = Color(0xFFF4F4F5)
val DarkOnSurface = Color(0xFFF4F4F5)
val DarkOutline = Color(0xFF52525B)
val DarkOutlineVariant = Color(0xFF3F3F46)

// Variaciones accesibles para Tema Oscuro con alto contraste
val DarkPrimary = Color(0xFFEF5350)     // Rojo optimizado para contraste en fondo oscuro
val DarkSecondary = Color(0xFFFAFAFA)   // Blanco / Gris ultra claro para modo oscuro
val DarkAccent = Color(0xFFFF8A80)
