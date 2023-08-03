package com.marcosmontiel.userssp.presentation.screen.user

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val application: Application) : ViewModel() {

    // Shared Preferences

    private val sharedPreferences = application.getSharedPreferences(
        "app_settings",
        Context.MODE_PRIVATE,
    )

    val isFirstTime = sharedPreferences.getBoolean("user_first_time", true)
    val username = sharedPreferences.getString("user_username_value", "")

    // State form

    var state by mutableStateOf(UserState())
        private set

    // Events

    fun saveUser(errorMessage: String) {

        if (state.username.isEmpty() || state.username.isBlank()) {
            Toast.makeText(application.applicationContext, errorMessage, Toast.LENGTH_LONG).show()
            return
        }

        state = state.copy(showAddUserDialog = false)
        sharedPreferences.edit().putBoolean("user_first_time", false).apply()
        sharedPreferences.edit().putString("user_username_value", state.username).apply()
    }

    fun valueChange(maxLength: Int, username: String) {

        val value: String = username.let {
            if (it.length > maxLength) it.slice(0 until maxLength) else it
        }

        state = state.copy(username = value)

    }

}