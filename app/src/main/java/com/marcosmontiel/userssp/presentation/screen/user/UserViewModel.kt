package com.marcosmontiel.userssp.presentation.screen.user

import android.app.Application
import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(application: Application) : ViewModel() {

    // Shared Preferences

    private val sharedPreferences = application.getSharedPreferences(
        "app_settings",
        Context.MODE_PRIVATE,
    )

    val isFirstTime = sharedPreferences.getBoolean("first_time", true)

    // State form

    var state by mutableStateOf(UserState())
        private set

    // Events

    fun dismissDialog() {
        state = state.copy(showAddUserDialog = false)
    }

    fun valueChange(maxLength: Int, username: String) {

        val value: String = username.let {
            if (it.length > maxLength) it.slice(0 until maxLength) else it
        }

        state = state.copy(username = value)

    }

    fun hideDialog() {
        sharedPreferences.edit().putBoolean("first_time", false).apply()
    }

}