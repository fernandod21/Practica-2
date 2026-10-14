package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class ExampleRobolectricTest {

    @Test
    fun `read string app_name from context should be Bacano`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("Bacano", appName)
    }

    @Test
    fun `default greeting message is Hola mundo`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val defaultGreeting = context.getString(R.string.default_greeting_message)
        assertEquals("Hola mundo", defaultGreeting)
    }
}
