package com.example

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Pruebas unitarias para la lógica del sistema de diseño y saludo de Bacano.
 */
class MainViewModelTest {

    @Test
    fun `initial state has Hola mundo as greeting and false for dark theme`() {
        val viewModel = MainViewModel()
        val state = viewModel.uiState.value

        assertEquals("", state.nameInput)
        assertEquals("Hola mundo", state.greetingMessage)
        assertFalse(state.isDarkTheme)
    }

    @Test
    fun `greeting with name updates message to Hola, Name`() {
        val viewModel = MainViewModel()
        viewModel.onNameChange("Fernando")
        viewModel.onGreetClicked()

        val state = viewModel.uiState.value
        assertEquals("Hola, Fernando", state.greetingMessage)
        assertEquals(1, state.greetingCount)
    }

    @Test
    fun `greeting with empty or whitespace name keeps Hola mundo`() {
        val viewModel = MainViewModel()
        viewModel.onNameChange("   ")
        viewModel.onGreetClicked()

        val state = viewModel.uiState.value
        assertEquals("Hola mundo", state.greetingMessage)

        // After previous name, clearing and greeting returns to Hola mundo
        viewModel.onNameChange("Carlos")
        viewModel.onGreetClicked()
        assertEquals("Hola, Carlos", viewModel.uiState.value.greetingMessage)

        viewModel.onClearInput()
        viewModel.onGreetClicked()
        assertEquals("Hola mundo", viewModel.uiState.value.greetingMessage)
    }

    @Test
    fun `theme toggle correctly flips darkTheme state`() {
        val viewModel = MainViewModel()
        assertFalse(viewModel.uiState.value.isDarkTheme)

        viewModel.toggleTheme()
        assertTrue(viewModel.uiState.value.isDarkTheme)

        viewModel.toggleTheme()
        assertFalse(viewModel.uiState.value.isDarkTheme)
    }
}
