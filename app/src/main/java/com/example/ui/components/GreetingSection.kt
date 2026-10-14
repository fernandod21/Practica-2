package com.example.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.WavingHand
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.R

/**
 * Sección interactiva que contiene:
 * 1. Campo de texto con etiqueta "Nombre" e icono.
 * 2. Botón "Saludar" con icono, borde visible y esquinas redondeadas.
 * 3. Tarjeta de ejemplo con borde visible y esquinas redondeadas que inicialmente
 *    muestra "Hola mundo", y cambia suavemente a "Hola, [nombre]" al saludar.
 */
@Composable
fun GreetingSection(
    nameInput: String,
    greetingMessage: String,
    greetingCount: Int,
    onNameChange: (String) -> Unit,
    onGreetClick: () -> Unit,
    onClearClick: () -> Unit,
    onResetGreeting: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .testTag("greeting_section"),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Tarjeta con los controles de entrada (Campo + Botones)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("input_form_card"),
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.outline),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp)
            ) {
                // Título de la sección de interacción
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f)),
                        modifier = Modifier.size(36.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Filled.WavingHand,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text(
                            text = stringResource(R.string.interactive_section_title),
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onSurface,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Escribe tu nombre para actualizar la tarjeta",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))

                // Campo de texto para Nombre con icono y borde visible redondeado
                OutlinedTextField(
                    value = nameInput,
                    onValueChange = onNameChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("name_text_field"),
                    label = {
                        Text(
                            text = stringResource(R.string.name_field_label),
                            fontWeight = FontWeight.Medium
                        )
                    },
                    placeholder = {
                        Text(
                            text = stringResource(R.string.name_field_placeholder),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Icono de usuario",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    trailingIcon = {
                        if (nameInput.isNotEmpty()) {
                            IconButton(
                                onClick = onClearClick,
                                modifier = Modifier.testTag("clear_text_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Clear,
                                    contentDescription = "Limpiar campo",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                        focusedLabelColor = MaterialTheme.colorScheme.primary,
                        unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                        unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2f)
                    ),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = { onGreetClick() })
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Fila de botones con bordes visibles y esquinas redondeadas
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    // Botón principal "Saludar" con icono y bordes redondeados
                    Button(
                        onClick = onGreetClick,
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                            .testTag("greet_button"),
                        shape = RoundedCornerShape(14.dp),
                        border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.6f)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.WavingHand,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = stringResource(R.string.greet_button_text),
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    // Botón secundario "Restablecer" para volver a "Hola mundo"
                    OutlinedButton(
                        onClick = onResetGreeting,
                        modifier = Modifier
                            .height(50.dp)
                            .testTag("reset_button"),
                        shape = RoundedCornerShape(14.dp),
                        border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.outline),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = MaterialTheme.colorScheme.onSurface
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Refresh,
                            contentDescription = stringResource(R.string.clear_button_text),
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = stringResource(R.string.clear_button_text),
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }

        // 3. Tarjeta de Ejemplo (Greeting Card)
        GreetingCard(
            greetingMessage = greetingMessage,
            greetingCount = greetingCount
        )
    }
}

/**
 * Tarjeta de ejemplo solicitada:
 * - Inicialmente dice "Hola mundo".
 * - Al escribir un nombre y tocar "Saludar", muestra "Hola, [nombre]".
 * - Si el campo está vacío, mantiene "Hola mundo".
 * - Esquinas redondeadas (RoundedCornerShape 20.dp).
 * - Borde visible (BorderStroke 2.dp con color de marca animado).
 * - Animación suave al actualizar el texto (AnimatedContent).
 */
@Composable
fun GreetingCard(
    greetingMessage: String,
    greetingCount: Int,
    modifier: Modifier = Modifier
) {
    val isCustomGreeting = greetingMessage != stringResource(R.string.default_greeting_message)

    // Borde animado que resalta suavemente al personalizar el saludo
    val targetBorderColor = if (isCustomGreeting) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.outline
    }

    val animatedBorderColor = animateColorAsState(
        targetValue = targetBorderColor,
        animationSpec = tween(durationMillis = 300),
        label = "greetingCardBorder"
    ).value

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("greeting_example_card"),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(2.dp, animatedBorderColor),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            // Encabezado de la tarjeta con chip identificador
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary.copy(alpha = 0.5f))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Filled.AutoAwesome,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onTertiaryContainer,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = stringResource(R.string.greeting_card_title),
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                    }
                }

                if (greetingCount > 0) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                    ) {
                        Text(
                            text = "Saludos: $greetingCount",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Contenido animado del Saludo (Requisito 5: Animación suave)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                AnimatedContent(
                    targetState = greetingMessage,
                    transitionSpec = {
                        (fadeIn(animationSpec = tween(durationMillis = 280)) +
                                slideInVertically(
                                    animationSpec = tween(durationMillis = 280),
                                    initialOffsetY = { fullHeight -> fullHeight / 3 }
                                ))
                            .togetherWith(
                                fadeOut(animationSpec = tween(durationMillis = 200)) +
                                        slideOutVertically(
                                            animationSpec = tween(durationMillis = 200),
                                            targetOffsetY = { fullHeight -> -fullHeight / 3 }
                                        )
                            )
                    },
                    label = "greetingAnimation"
                ) { targetText ->
                    Text(
                        text = targetText,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = if (targetText == stringResource(R.string.default_greeting_message)) {
                            MaterialTheme.colorScheme.onSurface
                        } else {
                            MaterialTheme.colorScheme.primary
                        },
                        modifier = Modifier.testTag("greeting_text_display")
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Explicación contextual de la tarjeta
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = if (isCustomGreeting) {
                        "Estado dinámico activo con el nombre ingresado. Borde resaltado con el color primario de Bacano."
                    } else {
                        "Estado predeterminado. Ingresa un nombre arriba y presiona 'Saludar' para ver la animación."
                    },
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}
