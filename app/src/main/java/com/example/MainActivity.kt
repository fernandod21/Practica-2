package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.components.GreetingSection
import com.example.ui.components.PaletteSection
import com.example.ui.components.TopAppBarBacano
import com.example.ui.theme.BacanoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val mainViewModel: MainViewModel = viewModel()
            val uiState by mainViewModel.uiState.collectAsStateWithLifecycle()

            BacanoTheme(darkTheme = uiState.isDarkTheme) {
                BacanoAppScreen(
                    uiState = uiState,
                    onNameChange = mainViewModel::onNameChange,
                    onGreetClick = mainViewModel::onGreetClicked,
                    onClearClick = mainViewModel::onClearInput,
                    onResetGreeting = mainViewModel::onResetGreeting,
                    onToggleTheme = mainViewModel::toggleTheme,
                    onSelectColor = mainViewModel::onSelectColor
                )
            }
        }
    }
}

/**
 * Pantalla Principal del Sistema de Diseño Bacano.
 * Incorpora el logotipo oficial de Bacano Studio en la barra superior y los 6 elementos del sistema:
 * 1. Tipografía (Plus Jakarta Sans)
 * 2. Colores (Paleta oficial: Rojo, Negro y Blanco)
 * 3. Temas (Control funcional claro/oscuro con transición suave)
 * 4. Iconos (Nombre, botón saludar y control de tema)
 * 5. Animaciones (Actualización suave de saludo y transición de tema)
 * 6. Bordes (Bordes visibles y esquinas redondeadas)
 */
@Composable
fun BacanoAppScreen(
    uiState: BacanoUiState,
    onNameChange: (String) -> Unit,
    onGreetClick: () -> Unit,
    onClearClick: () -> Unit,
    onResetGreeting: () -> Unit,
    onToggleTheme: () -> Unit,
    onSelectColor: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing),
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .widthIn(max = 600.dp)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Barra superior con marca "Bacano", logotipo oficial y control de tema claro/oscuro
                TopAppBarBacano(
                    isDarkTheme = uiState.isDarkTheme,
                    onToggleTheme = onToggleTheme
                )

                // Sección 1: Paleta de tres colores con cuadros y códigos hexadecimales
                PaletteSection(
                    selectedHex = uiState.selectedColorHex,
                    onSelectColor = onSelectColor
                )

                // Sección 2: Campo "Nombre", botón "Saludar" y Tarjeta de ejemplo animada
                GreetingSection(
                    nameInput = uiState.nameInput,
                    greetingMessage = uiState.greetingMessage,
                    greetingCount = uiState.greetingCount,
                    onNameChange = onNameChange,
                    onGreetClick = onGreetClick,
                    onClearClick = onClearClick,
                    onResetGreeting = onResetGreeting
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BacanoAppScreenLightPreview() {
    BacanoTheme(darkTheme = false) {
        BacanoAppScreen(
            uiState = BacanoUiState(
                nameInput = "Fernando",
                greetingMessage = "Hola, Fernando",
                isDarkTheme = false
            ),
            onNameChange = {},
            onGreetClick = {},
            onClearClick = {},
            onResetGreeting = {},
            onToggleTheme = {},
            onSelectColor = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BacanoAppScreenDarkPreview() {
    BacanoTheme(darkTheme = true) {
        BacanoAppScreen(
            uiState = BacanoUiState(
                nameInput = "",
                greetingMessage = "Hola mundo",
                isDarkTheme = true
            ),
            onNameChange = {},
            onGreetClick = {},
            onClearClick = {},
            onResetGreeting = {},
            onToggleTheme = {},
            onSelectColor = {}
        )
    }
}
