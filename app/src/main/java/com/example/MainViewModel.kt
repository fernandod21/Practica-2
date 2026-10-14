package com.example

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Estado UI de la pantalla principal de Bacano.
 */
data class BacanoUiState(
    val nameInput: String = "",
    val greetingMessage: String = "Hola mundo",
    val isDarkTheme: Boolean = false,
    val selectedColorHex: String? = null,
    val greetingCount: Int = 0
)

/**
 * ViewModel que maneja la lógica de negocio y estado del Sistema de Diseño Bacano.
 */
class MainViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(BacanoUiState())
    val uiState: StateFlow<BacanoUiState> = _uiState.asStateFlow()

    fun onNameChange(newName: String) {
        _uiState.update { it.copy(nameInput = newName) }
    }

    /**
     * Al tocar "Saludar":
     * - Si el campo tiene un nombre, muestra "Hola, [nombre]".
     * - Si el campo está vacío, mantiene "Hola mundo".
     */
    fun onGreetClicked() {
        _uiState.update { current ->
            val trimmed = current.nameInput.trim()
            val newGreeting = if (trimmed.isNotEmpty()) {
                "Hola, $trimmed"
            } else {
                "Hola mundo"
            }
            current.copy(
                greetingMessage = newGreeting,
                greetingCount = current.greetingCount + 1
            )
        }
    }

    fun onClearInput() {
        _uiState.update { it.copy(nameInput = "") }
    }

    fun onResetGreeting() {
        _uiState.update {
            it.copy(
                nameInput = "",
                greetingMessage = "Hola mundo"
            )
        }
    }

    fun toggleTheme() {
        _uiState.update { it.copy(isDarkTheme = !it.isDarkTheme) }
    }

    fun onSelectColor(hex: String) {
        _uiState.update {
            it.copy(selectedColorHex = if (it.selectedColorHex == hex) null else hex)
        }
    }
}
