package com.marcosmontiel.userssp.presentation.screen.user

import android.app.Application
import android.content.Context
import android.util.Log
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

    init {

        val isFirstTime = sharedPreferences.getBoolean("first_time", true)
        Log.i("UserViewModel", "$isFirstTime")

        if (isFirstTime) {
            sharedPreferences.edit().putBoolean("first_time", false).apply()
        }

    }

}